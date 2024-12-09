import { Component } from '@angular/core';
import { LogInService } from '../../../services/log-in.service';
import Cookies from 'js-cookie';
import Login from '../../../interfaces/login';
import { environment } from '../../../../environments/environment';
import * as CryptoJS from 'crypto-js';
import { ActivatedRoute } from '@angular/router';

import { infoAlert, redirectAlert } from '../../../../assets/alerts'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthGoogleService } from '../../../services/auth-google.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  url:string = '';
  private sesion:Login = {
    idUsuario: 0,
    correo: "",
    contraseña: "",
    token: "",
    rol: 0
  }

  formLogin!: FormGroup;
  constructor(
    private _logInService:LogInService, 
    private _route:ActivatedRoute, 
    private fb:FormBuilder,
    private _authGoogleService: AuthGoogleService
  ) {
    this.buildForm();
   }

  ngOnInit(): void {
  }

  private buildForm(){
    const mailRgx = /^[^\s@]+@+(hotmail|gmail|outlook)\.(com|co|edu\.co)$/;
    const pswRgx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,15}/;

    this.formLogin = this.fb.group({
      email: ['', [Validators.required, Validators.pattern(mailRgx), Validators.minLength(10), Validators.maxLength(50)]],
      password: ['', [Validators.required, Validators.pattern(pswRgx), Validators.minLength(8), Validators.maxLength(15)]]
    });
  }

  private getInformation(){
    this.sesion.correo = this.formLogin.get('email')?.value;
    this.sesion.contraseña = this.formLogin.get('password')?.value;
  }

  public logIn(){

    this._route.queryParamMap.subscribe((params) => {
      const redirectUrl = params.get('redirectUrl') || '';
      this.url = redirectUrl;
    });  
      
      this.getInformation();
      this._logInService.logIn(this.sesion).subscribe({
        next: (data) => {
          if(data.datos.idUsuario != 0){
            // console.log("Sesión iniciada " + data.datos.idUsuario);
            localStorage.setItem('user', CryptoJS.AES.encrypt( data.datos.idUsuario.toString(), environment.cryptPassword).toString());
            localStorage.setItem('rol', CryptoJS.AES.encrypt( data.datos.rol.toString(), environment.cryptPassword).toString());
            Cookies.set('authToken', CryptoJS.AES.encrypt( data.datos.token.toString(), environment.cryptPassword).toString(), {
              expires: 1,
              secure: false,
              sameSite: 'Strict',
              httpOnly: false
            });

            if(this.url === ''){
              
              (data.datos.rol == 1)?window.location.href = '/admin': window.location.href = '/store';

            }else{
              window.location.href = this.url;
            }
          }
        },
        error: (error) => {
          infoAlert('error', 'Error', 'Usuario o contraseña incorrectos.');
          console.log(error);
        }
      });
  }

  public async authGoogle(){
    try {
      
      const register = await this._authGoogleService.loginGoogle();

      if(register){
        this._authGoogleService.authState$().subscribe({
          next: (data) => {
            if (data) {
              const sesion:Login = {
                idUsuario: 0,
                correo: data.email,
                contraseña: "",
                token: "",
                rol: 0
              }
              this._logInService.logIn(sesion).subscribe({
                next: (res) => {
                  console.log(res);
                  localStorage.setItem('rol', CryptoJS.AES.encrypt(res.datos.rol.idRol, environment.cryptPassword).toString());
                  localStorage.setItem('user', CryptoJS.AES.encrypt(res.datos.idUsuario.toString(), environment.cryptPassword).toString());
                  redirectAlert("success", "Logueo exitoso", "store");
                },
                error: (err) => {
                  console.log('Usuario no encontrado:', err);

                }
              })          
            }
          },
          error: (err) => {
            console.log('Error en la autenticación:', err);
          }
        }); 
      }
    }catch (error) {
      console.log(error);
    }
  }

}
