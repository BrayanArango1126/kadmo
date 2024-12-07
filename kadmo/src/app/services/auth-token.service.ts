import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import Cookies from 'js-cookie';
import { infoAlert } from '../../assets/alerts';
import * as cryptoJS from 'crypto-js';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthTokenService {

  constructor(private router: Router) { }

  public getToken(): string | undefined {
    return Cookies.get('authToken'); // 'token' es el nombre de tu cookie
  }
  public isTokenExpired(): boolean {
    let claveTokenCrypto = this.getToken();
    console.log(claveTokenCrypto);
    if (!claveTokenCrypto) return true;
    const token = cryptoJS.AES.decrypt(claveTokenCrypto, environment.cryptPassword).toString(cryptoJS.enc.Utf8);

    if (!token) return true;

    const payload = JSON.parse(atob(token.split('.')[1])); // Decodifica el payload del JWT
    const expirationDate = payload.exp * 1000; // Convierte el tiempo UNIX a milisegundos
    return Date.now() > expirationDate;
  }

  public logOut(): void {
    localStorage.clear();
    Cookies.remove('authToken');    // Borra la cookie del token
    this.router.navigate(['/store']);  // Redirige al login
  }

  checkSession(): void {
    if (this.isTokenExpired()) {
      infoAlert('info', 'Tu sesión ha expirado, por favor inicia sesión de nuevo.', 'Adiós');
      this.logOut();
    }
  }
}
