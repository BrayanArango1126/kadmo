import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ResponseApi } from '../interfaces/response-api';

import { environment } from '../../environments/environment';
import Usuario from '../interfaces/usuario';
import DatosUsuario from '../interfaces/datosUsuario';

// @Injectable({
//   providedIn: 'root'
// })
// export class UsuarioService {

//   private urlApi:string = environment.endpoint + "Usuario/";


//   constructor(private http:HttpClient) { }

//   Registrarse(request:Usuario):Observable<ResponseApi>{
//     return this.http.post<ResponseApi>(`${this.urlApi}add-usuario`, request);
//   }

// }

