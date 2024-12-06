import { CanActivateFn } from '@angular/router';
import { environment } from '../../environments/environment';
import * as cryptoJS from 'crypto-js';

export const authGuard: CanActivateFn = (route, state) => {
  const rol = localStorage.getItem('rol') || '';
  const decrptRol = cryptoJS.AES.decrypt(rol, environment.cryptPassword).toString(cryptoJS.enc.Utf8);
  if(!decrptRol || decrptRol != '1'){
    alert('Inicia sesión como administrador para continuar.');
    window.location.href = '/login';
    return false;
  }else{
    return true;
  }
  
};

function getRolUser(rol:number){

}
