import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import LibroPublicado from '../interfaces/libroPublicado';
import { ResponseApi } from '../interfaces/response-api';

@Injectable({
  providedIn: 'root'
})
export class LibrosPublicadosService {

  private endPoint:string = environment.endpoint + '/libro-publicado';
  constructor(private http:HttpClient) { }

  public getLibrosPublicados():Observable<LibroPublicado[]>{
    return this.http.get<LibroPublicado[]>(`${this.endPoint}/libros-publicados`);
  }

  public getLibroPublicado(id:number):Observable<LibroPublicado>{
    return this.http.get<LibroPublicado>(`${this.endPoint}/libro-publicado/${id}`);
  }

  public addLibroPublicado(libro:LibroPublicado):Observable<ResponseApi>{
    return this.http.post<ResponseApi>(`${this.endPoint}/add-libro-publicado`, libro);
  }
}
