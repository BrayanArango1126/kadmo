import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ResponseApi } from '../interfaces/response-api';

import axios from 'axios';
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

export const UsuarioService = {
  async getUsuariosList() {
    return axios.get(`${environment.endpoint}/usuarios/list`);
  },
  async getUsuariosById(idUsuario: number) {
    return axios.get(`${environment.endpoint}/usuarios/${idUsuario}`);
  },
  async registrarUsuario(usuario: Usuario) {
    return axios.post(`${environment.endpoint}/usuario/add-usuario`, usuario);
  },
  async registrarDatosUsuarios(DatoUsuario: DatosUsuario) {
    return axios.post(`${environment.endpoint}/dato-usuario/add-dato-usuario`, DatoUsuario);
  },
  async loginUsuario(usuario: Usuario) {
    return axios.post(`${environment.endpoint}/usuarios/login`, usuario);
  }
};
