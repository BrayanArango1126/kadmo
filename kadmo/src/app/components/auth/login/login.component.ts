import { Component } from '@angular/core';
import { LogInService } from '../../../services/log-in.service';
import Cookies from 'js-cookie';
import Login from '../../../interfaces/login';
import { environment } from '../../../../environments/environment';
import * as CryptoJS from 'crypto-js';
import { ActivatedRoute } from '@angular/router';

import { infoAlert } from '../../../../assets/alerts'


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
  constructor(private _logInService:LogInService, private _route:ActivatedRoute) { }

  ngOnInit(): void {
  }

  private getInformation(mail:string, password:string){
    this.sesion.correo = mail;
    this.sesion.contraseña = password;
  }

  public logIn(mail:string, password:string){

    this._route.queryParamMap.subscribe((params) => {
      const redirectUrl = params.get('redirectUrl') || '';
      this.url = redirectUrl;
    });  
      
      this.getInformation(mail, password);
      this._logInService.logIn(this.sesion).subscribe({
        next: (data) => {
          if(data.datos.idUsuario != 0){
            // console.log("Sesión iniciada " + data.datos.idUsuario);
            localStorage.setItem('user', CryptoJS.AES.encrypt( data.datos.idUsuario.toString(), environment.cryptPassword).toString());
            localStorage.setItem('rol', CryptoJS.AES.encrypt( data.datos.rol.toString(), environment.cryptPassword).toString());
            Cookies.set('authToken', data.datos.token, {
              expires: 1,
              secure: false,
              sameSite: 'Strict',
              httpOnlt: false
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

}
