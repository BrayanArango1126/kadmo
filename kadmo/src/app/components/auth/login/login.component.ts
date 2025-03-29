import { Component, ElementRef, ViewChild } from '@angular/core';
import { LogInService } from '../../../services/log-in.service';
import Cookies from 'js-cookie';
import Login from '../../../interfaces/login';
import { environment } from '../../../../environments/environment';
import * as CryptoJS from 'crypto-js';
import { ActivatedRoute, Router } from '@angular/router';

import { infoAlert, redirectAlert } from '../../../../assets/alerts';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthGoogleService } from '../../../services/auth-google.service';
import { HttpClient } from '@angular/common/http';
import * as bootstrap from 'bootstrap';
import { UsuarioService } from '../../../services/usuario.service';
import Usuario from '../../../interfaces/usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  @ViewChild('videoElement') videoElement!: ElementRef;
  @ViewChild('canvasElement') canvasElement!: ElementRef;
  @ViewChild('faceModal', { static: false }) faceModal!: ElementRef; // Captura el modal

  private modalInstance: any; // Variable para almacenar la instancia del modal
  isActive: boolean = false;

  usuarioEncontrado!: Usuario;

  responseMessage: string = '';
  streaming = false;

  url: string = '';
  private sesion: Login = {
    idUsuario: 0,
    correo: '',
    contraseña: '',
    token: '',
    rol: 0,
  };

  formLogin!: FormGroup;
  constructor(
    private _logInService: LogInService,
    private _route: ActivatedRoute,
    private fb: FormBuilder,
    private _authGoogleService: AuthGoogleService,
    private http: HttpClient,
    private router: Router,
    private _usuarioService: UsuarioService
  ) {
    this.buildForm();
  }

  ngOnInit(): void {}

  ngAfterViewInit(): void {
    this.startCamera();
  }

  private buildForm() {
    const mailRgx = /^[^\s@]+@+(hotmail|gmail|outlook)\.(com|co|edu\.co)$/;
    const pswRgx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,15}/;

    this.formLogin = this.fb.group({
      email: [
        '',
        [
          Validators.required,
          Validators.pattern(mailRgx),
          Validators.minLength(10),
          Validators.maxLength(50),
        ],
      ],
      password: [
        '',
        [
          Validators.required,
          Validators.pattern(pswRgx),
          Validators.minLength(8),
          Validators.maxLength(15),
        ],
      ],
    });
  }

  private getInformation() {
    this.sesion.correo = this.formLogin.get('email')?.value;
    this.sesion.contraseña = this.formLogin.get('password')?.value;
  }

  public logIn() {
    this._route.queryParamMap.subscribe((params) => {
      const redirectUrl = params.get('redirectUrl') || '';
      this.url = redirectUrl;
    });

    this.getInformation();
    this._logInService.logIn(this.sesion).subscribe({
      next: (data) => {
        if (data.datos.idUsuario != 0) {
          // console.log("Sesión iniciada " + data.datos.idUsuario);
          localStorage.setItem(
            'user',
            CryptoJS.AES.encrypt(
              data.datos.idUsuario.toString(),
              environment.cryptPassword
            ).toString()
          );
          localStorage.setItem(
            'rol',
            CryptoJS.AES.encrypt(
              data.datos.rol.toString(),
              environment.cryptPassword
            ).toString()
          );
          Cookies.set(
            'authToken',
            CryptoJS.AES.encrypt(
              data.datos.token.toString(),
              environment.cryptPassword
            ).toString(),
            {
              expires: 1,
              secure: false,
              sameSite: 'Strict',
              httpOnly: false,
            }
          );

          if (this.url === '') {
            data.datos.rol == 1
              ? (window.location.href = '/admin/reportes')
              : (window.location.href = '/store');
          } else {
            window.location.href = this.url;
          }
        }
      },
      error: (error) => {
        infoAlert('error', 'Error', 'Usuario o contraseña incorrectos.');
        console.log(error);
      },
    });
  }

  startCamera(): void {
    navigator.mediaDevices
      .getUserMedia({ video: true })
      .then((stream) => {
        const video = this.videoElement.nativeElement as HTMLVideoElement;
        video.srcObject = stream;
        video.play();
        this.streaming = true;
      })
      .catch((err) => {
        console.error('Error accessing camera:', err);
        this.responseMessage = 'No se pudo acceder a la cámara';
      });
  }

  captureImage(): void {
    const video = this.videoElement.nativeElement as HTMLVideoElement;
    const canvas = this.canvasElement.nativeElement as HTMLCanvasElement;
    const context = canvas.getContext('2d');
    if (!context) {
      console.error('Error: No se pudo obtener el contexto del canvas.');
      this.responseMessage = 'Error al capturar la imagen.';
      return;
    }
    canvas.width = video.videoWidth;
    canvas.height = video.videoHeight;
    context.drawImage(video, 0, 0, canvas.width, canvas.height);
    this.sendImageToServer(canvas.toDataURL('image/jpeg'));
  }

  public openModal() {
    if (this.faceModal && this.faceModal.nativeElement) {
      this.modalInstance = new bootstrap.Modal(this.faceModal.nativeElement);
      this.modalInstance.show();
    } else {
      console.error('Error: El modal no se ha inicializado correctamente.');
    }
  }

  sendImageToServer(base64Image: string): void {
    const blob = this.dataURLtoBlob(base64Image);
    const formData = new FormData();
    formData.append('image', blob, 'captured.jpg');

    this.http
      .post<any>('http://127.0.0.1:5005/login-face', formData)
      .subscribe({
        next: (res) => {
          this.responseMessage = `¡Login exitoso!`;
          // Redirigir a dashboard u otra ruta

          this.findUserById(res.user);

          this.isActive = false;
          if (this.modalInstance) {
            this.modalInstance.hide();
          }
        },
        error: (err) => {
          this.responseMessage = err.error?.error || 'Error en el login';
        },
      });
  }

  findUserById(id: number): void {
    this._usuarioService.getUsuarioById(id).subscribe({
      next: (res) => {
        this.usuarioEncontrado = res;
        // Aquí puedes realizar acciones adicionales con el usuario encontrado
        const sesion: Login = {
          idUsuario: this.usuarioEncontrado.idUsuario,
          correo: this.usuarioEncontrado.correo,
          contraseña: '',
          token: '',
          rol: this.usuarioEncontrado.rol.idRol,
        };

        this.loginFace(sesion);
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  loginFace(login: Login) {
    this._logInService.logInFace(login).subscribe({
      next: (res) => {
        localStorage.setItem(
          'rol',
          CryptoJS.AES.encrypt(
            res.datos.rol.idRol,
            environment.cryptPassword
          ).toString()
        );
        localStorage.setItem(
          'user',
          CryptoJS.AES.encrypt(
            res.datos.idUsuario.toString(),
            environment.cryptPassword
          ).toString()
        );
        redirectAlert('success', 'Logueo exitoso', 'store');
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  dataURLtoBlob(dataURL: string): Blob {
    const byteString = atob(dataURL.split(',')[1]);
    const mimeString = dataURL.split(',')[0].split(':')[1].split(';')[0];

    const ab = new ArrayBuffer(byteString.length);
    const ia = new Uint8Array(ab);
    for (let i = 0; i < byteString.length; i++) {
      ia[i] = byteString.charCodeAt(i);
    }

    return new Blob([ab], { type: mimeString });
  }

  public async authGoogle() {
    try {
      const register = await this._authGoogleService.loginGoogle();

      if (register) {
        this._authGoogleService.authState$().subscribe({
          next: (data) => {
            if (data) {
              const sesion: Login = {
                idUsuario: 0,
                correo: data.email,
                contraseña: '',
                token: '',
                rol: 0,
              };
              this._logInService.logIn(sesion).subscribe({
                next: (res) => {
                  console.log(res);
                  localStorage.setItem(
                    'rol',
                    CryptoJS.AES.encrypt(
                      res.datos.rol.idRol,
                      environment.cryptPassword
                    ).toString()
                  );
                  localStorage.setItem(
                    'user',
                    CryptoJS.AES.encrypt(
                      res.datos.idUsuario.toString(),
                      environment.cryptPassword
                    ).toString()
                  );
                  redirectAlert('success', 'Logueo exitoso', 'store');
                },
                error: (err) => {
                  console.log('Usuario no encontrado:', err);
                },
              });
            }
          },
          error: (err) => {
            console.log('Error en la autenticación:', err);
          },
        });
      }
    } catch (error) {
      console.log(error);
    }
  }
}
