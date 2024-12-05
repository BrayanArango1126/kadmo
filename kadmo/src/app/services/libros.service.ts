import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { ResponseApi } from '../interfaces/response-api';
import { Observable } from 'rxjs';
import Libros from '../interfaces/libros';
import FiltroLibros from '../interfaces/filtroLibrosDTO';

@Injectable({
  providedIn: 'root'
})
export class LibrosService {

  private endPoint:String = environment.endpoint + "/libro";
  constructor(private http:HttpClient) { }

  private header = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')
  //.set('X-API-KEY', 'ANGULAR')
  .set('Accept', 'application/json');

  private options={
    headers:this.header
  }

  public getLibros():Observable<Libros[]>{
    return this.http.get<Libros[]>(`${this.endPoint}/libros`, this.options);
  }

  public getLibro(id:number):Observable<Libros>{
    return this.http.get<Libros>(`${this.endPoint}/libro/${id}`, this.options);
  }

  public addLibro(libro:Libros):Observable<ResponseApi>{
    return this.http.post<ResponseApi>(`${this.endPoint}/add-libro`, libro, this.options);
  }

  public filterLibros(filter:FiltroLibros):Observable<Libros[]>{
    return this.http.post<Libros[]>(`${this.endPoint}/filtro-libros`, filter, this.options);
  }

  public getLibroById(id:number):Observable<Libros>{
    return this.http.get<Libros>(`${this.endPoint}/libro-id?idLibros=${id}`);
  }

  public updateLibro(libro:Libros):Observable<ResponseApi>{
    return this.http.put<ResponseApi>(`${this.endPoint}/update-libro`, libro, this.options);
  }
}
