import { ActivatedRoute, CanActivateFn, Router } from '@angular/router';
import { environment } from '../../environments/environment';
import * as cryptoJS from 'crypto-js';
import { redirectAlert } from '../../assets/alerts';
import { inject } from '@angular/core';

export const authGuard = (): CanActivateFn => {
  return () => {
    const rol = localStorage.getItem('rol') || '';
    if (!rol) {
      redirectAlert('info', 'Inicie sesión primero', 'login');
      return false;
    }
    
    return true;

  }
}

export const adminGuard = (): CanActivateFn => {
  return () => {
    const rol = localStorage.getItem('rol') || '';
    const decrptRol = cryptoJS.AES.decrypt(rol,environment.cryptPassword).toString(cryptoJS.enc.Utf8);
    if (decrptRol != '1') {
      redirectAlert('info', 'Inicie sesión como administrador', 'login');
      return false;
    } else {
      return true;
    }
  };
};

export const userGuard = (): CanActivateFn => {
  return () => {
    const rol = localStorage.getItem('rol') || '';
    const decrptRol = cryptoJS.AES.decrypt(rol, environment.cryptPassword).toString(cryptoJS.enc.Utf8);
    if (decrptRol == '1') {
      redirectAlert('info', 'Inicie sesión con una cuenta distinta', 'login');
      return false;
    } else {
      return true;
    }

  }
};

export const redirectGuard = (): CanActivateFn => {
  return () => {
    
    const _route = inject(Router);
    const rol = localStorage.getItem('rol') || '';
    const decrptRol = cryptoJS.AES.decrypt(rol, environment.cryptPassword).toString(cryptoJS.enc.Utf8);
    if (!decrptRol) {
      return true;
    }else if (decrptRol == '1') {
      _route.navigateByUrl('/admin');
      return true;
    }else if (decrptRol != '1') {
      _route.navigateByUrl('/store');
      return true;
    }else if (!decrptRol) {
      _route.navigateByUrl('/store');
      return true;
    }
    return false;
  }
};
