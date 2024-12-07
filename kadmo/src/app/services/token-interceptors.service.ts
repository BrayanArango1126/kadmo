import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthTokenService } from './auth-token.service';
import { Observable } from 'rxjs';
import * as cryptoJS from 'crypto-js';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorsService implements HttpInterceptor {

  constructor(private _authService: AuthTokenService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let tokenCrypto = this._authService.getToken();
    if (!tokenCrypto) return next.handle(req);
    const token = cryptoJS.AES.decrypt(tokenCrypto, environment.cryptPassword).toString(cryptoJS.enc.Utf8);

    if (token) {
        const cloned = req.clone({
            setHeaders: {
                Authorization: `Bearer ${token}` // Agrega el token al encabezado
            }
        });
        return next.handle(cloned);
    }

    return next.handle(req);
}
}
