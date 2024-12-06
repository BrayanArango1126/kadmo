import { Component } from '@angular/core';
import { LogInService } from '../../../services/log-in.service';
import Cookies from 'js-cookie';
import Login from '../../../interfaces/login';
import { environment } from '../../../../environments/environment';
import * as CryptoJS from 'crypto-js';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  private sesion:Login = {
    idUsuario: 0,
    correo: "",
    contraseña: "",
    token: "",
    rol: 0
  }
  constructor(private _logInService:LogInService) { }

  ngOnInit(): void {
  }

  private getInformation(mail:string, password:string){
    this.sesion.correo = mail;
    this.sesion.contraseña = password;
  }

  public logIn(mail:string, password:string){
    this.getInformation(mail, password);
    this._logInService.logIn(this.sesion).subscribe({
      next: (data) => {
        if(data.datos.idUsuario != 0){
          console.log("Sesión iniciada " + data.datos.idUsuario);
          localStorage.setItem('user', CryptoJS.AES.encrypt( data.datos.idUsuario.toString(), environment.cryptPassword).toString());
          localStorage.setItem('rol', CryptoJS.AES.encrypt( data.datos.rol.toString(), environment.cryptPassword).toString());
          Cookies.set('authToken', data.datos.token, {
            expires: 1,
            secure: false,
            sameSite: 'Strict',
            httpOnlt: false
          });
          if(data.datos.rol == 1){
            window.location.href = '/admin';
          }else{
            window.location.href = '/store';
          }
        }
      },
      error: (error) => {
        console.log(error);
      }
    });
  }

}
