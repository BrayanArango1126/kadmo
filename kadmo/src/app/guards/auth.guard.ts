import { CanActivateFn } from '@angular/router';
import { environment } from '../../environments/environment';
import * as cryptoJS from 'crypto-js';
import { redirectAlert } from '../../assets/alerts';

export const authGuard: CanActivateFn = (route, state) => {
  const rol = localStorage.getItem('rol') || '';
  const decrptRol = cryptoJS.AES.decrypt(rol, environment.cryptPassword).toString(cryptoJS.enc.Utf8);
  const allowedRoles = route.data['ValidateRol'] || [];
  
  if (allowedRoles == 1 && decrptRol != '1') {
    redirectAlert("info", "Inicie sesión como administrador", "login");
    return false;
  }else if(allowedRoles == 2 && !decrptRol){
    redirectAlert("info", "Inicie sesión primero", "login");
    return false;
  }
  else{
    return true;
  }
  
};
