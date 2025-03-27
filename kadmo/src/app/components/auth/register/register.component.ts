import { Component, ElementRef, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, FormsModule  } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RolesService } from '../../../services/roles.service';
import Rol from '../../../interfaces/rol';
import { Router } from '@angular/router';
import { UsuarioService } from '../../../services/usuario.service';
import Usuario from '../../../interfaces/usuario';
import { infoAlert, redirectAlert } from '../../../../assets/alerts';
import { AuthGoogleService } from '../../../services/auth-google.service';
import { environment } from '../../../../environments/environment';
import * as cryptoJS from 'crypto-js';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  // imports: [HttpClientModule],
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  @ViewChild('videoElement') videoElement!: ElementRef;
  @ViewChild('canvasElement') canvasElement!: ElementRef;

  username: string = '';
  responseMessage: string = '';
  streaming = false;
  listAllRoles: Rol[] = [];
  registerForm!: FormGroup;
  commonModule!: CommonModule; 
  formsModule!:FormsModule;

  constructor(
    private fb: FormBuilder, 
    private _rolService: RolesService, 
    private _usuarioService: UsuarioService,
    private _authGoogleService: AuthGoogleService,
    private http: HttpClient,
    private router: Router
  ) {
    this.buildForm();
  }

  ngOnInit(): void {
    this.getAllRoles();
  }
  startCamera(): void {
    navigator.mediaDevices.getUserMedia({ video: true })
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
    if (context) {
      canvas.width = video.videoWidth;
      canvas.height = video.videoHeight;
      context.drawImage(video, 0, 0, canvas.width, canvas.height);
      this.sendImageToServer(canvas.toDataURL('image/jpeg'));
    }
  }

  sendImageToServer(base64Image: string): void {
    if (!this.username.trim()) {
      this.responseMessage = 'Por favor ingresa un nombre de usuario';
      return;
    }

    const blob = this.dataURLtoBlob(base64Image);
    const formData = new FormData();
    formData.append('image', blob, 'register.jpg');
    formData.append('username', this.username);

    this.http.post<any>('http://127.0.0.1:5000/register', formData).subscribe({
      next: (res) => {
        this.responseMessage = `Usuario ${this.username} registrado con éxito`;
        setTimeout(() => {
          this.router.navigate(['/login']);
        }, 2000);
      },
      error: (err) => {
        this.responseMessage = err.error?.error || 'Error al registrar';
      }
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

  ngAfterViewInit(): void {
    this.startCamera();
  }

  private buildForm(){
    const mailRgx = /^[^\s@]+@+(hotmail|gmail|outlook)\.(com|co|edu\.co)/;
    const pswRgx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,15}/;

    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.pattern(mailRgx), Validators.minLength(10), Validators.maxLength(50)]],
      password: ['', [Validators.required, Validators.pattern(pswRgx), Validators.minLength(8), Validators.maxLength(15)]],
      rol: ['', [Validators.required]],
    });
  }

  public getAllRoles(){
    this._rolService.getRoles().subscribe({
      next: roles => {
        roles.filter(rol => {
          if(rol.idRol !== 1){
            this.listAllRoles.push(rol);
          }
        });
        console.log(roles);
      },
      error: err => {
        console.log(err);
      }
    });
  }

  public register(){
    const newUser:Usuario = {
      idUsuario: 0,
      correo: this.registerForm.get('email')?.value,
      contraseña: this.registerForm.get('password')?.value,
      rol: {
        idRol: this.registerForm.get('rol')?.value
      }
    }
    this._usuarioService.Registrarse(newUser).subscribe({
      next: res => {
        redirectAlert("success", "Registro exitoso", "login");
      },
      error: err => {
        infoAlert("error", "Error", "Los datos ingresados no son válidos.");
        console.log(err);
      }
    });
  }

  public async authGoogle(){
    try {
      
      const register = await this._authGoogleService.loginGoogle();

      if(register){
        this._authGoogleService.authState$().subscribe((data) => {
          if (data) {
            const newUser:Usuario = {
              idUsuario: 0,
              correo: data.email,
              contraseña: '',
              rol: {
                idRol: 4
              }
            }
          this._usuarioService.Registrarse(newUser).subscribe({
            next: res => {
              console.log(res.datos.idUsuario);
              localStorage.setItem('rol', cryptoJS.AES.encrypt(res.datos.rol.idRol.toString(), environment.cryptPassword).toString());
              localStorage.setItem('user', cryptoJS.AES.encrypt(res.datos.idUsuario.toString(), environment.cryptPassword).toString());
              redirectAlert("success", "Registro exitoso", "store");
            },
            error: err => {
              infoAlert("error", "Error", "Los datos ingresados no son válidos.");
              console.log(err);
            }
          });
          console.log('Usuario autenticado:', data);
            
          } else {
            console.log('No hay usuario autenticado');
          }
        });
        
      }

    } catch (error) {
      console.log(error)
    }
  }

}
