import { Injectable } from '@angular/core';
import Cookies from 'js-cookie';

@Injectable({
  providedIn: 'root'
})
export class AuthTokenService {

  constructor() { }

  public logOut(){
    localStorage.clear();
    Cookies.remove('authToken');
    window.location.href = '/store';
  }

  public checkSession() {
    const token = Cookies.get('authToken');
    if (!token) {
      console.warn('Sesión expirada o token no encontrado.');
      this.logOut(); // Cerrar sesión en la aplicación
    }
  }
}
