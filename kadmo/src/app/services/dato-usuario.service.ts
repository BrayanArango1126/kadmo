import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import DatosUsuario from '../interfaces/datosUsuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DatoUsuarioService {

  constructor(private http:HttpClient) { }

  private endPoint = `${environment.endpoint}/dato-usuario`;
  
  private header = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')
  .set('Accept', 'application/json');

  private options={
    headers:this.header
  }

  getAllDatoUsuarios(): Observable<DatosUsuario[]> {
    return this.http.get<DatosUsuario[]>(`${this.endPoint}/datos-usuarios`, this.options);
  }
  
  getDatoUsuarioById(requestBody: { "idUsuario": number}):Observable<DatosUsuario> {
    return this.http.post<DatosUsuario>(`${this.endPoint}/dato-find-id-usuario`, requestBody, this.options);
  }
}
