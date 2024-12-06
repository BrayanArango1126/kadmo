import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ResponseApi } from '../interfaces/response-api';

import { environment } from '../../environments/environment';
import Usuario from '../interfaces/usuario';
import DatosUsuario from '../interfaces/datosUsuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private urlApi:string = environment.endpoint + "/usuario";


  constructor(private http:HttpClient) { }

  Registrarse(request:Usuario):Observable<ResponseApi>{
    return this.http.post<ResponseApi>(`${this.urlApi}/add-usuario`, request);
  }

  getUsuarioById(idUsuario:number):Observable<Usuario>{
    return this.http.get<Usuario>(`${this.urlApi}/usuario-id?idUsuario=${idUsuario}`);
  }

  getAllUsuarios():Observable<Usuario[]>{
    return this.http.get<Usuario[]>(`${this.urlApi}/usuarios`);
  }

  updateUsuario(usuario:Usuario):Observable<ResponseApi>{
    return this.http.put<ResponseApi>(`${this.urlApi}/update-usuario`, usuario);
  }

}

