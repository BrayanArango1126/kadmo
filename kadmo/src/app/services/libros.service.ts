import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { ResponseApi } from '../interfaces/response-api';
import { Observable } from 'rxjs';
import Libros from '../interfaces/libros';

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
}
