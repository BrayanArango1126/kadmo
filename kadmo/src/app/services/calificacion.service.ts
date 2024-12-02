import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import CalificacionLibro from '../interfaces/calificacionLibro';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import calificacionesByLibroId from '../interfaces/calificacionesByLibroId';

@Injectable({
  providedIn: 'root'
})
export class CalificacionService {

  constructor(private http:HttpClient) { }

  private endPoint:String = environment.endpoint + "/calificacion";

  private header = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')
  .set('Accept', 'application/json');

  private options={
    headers:this.header
  }

  public getCalificaciones(requestBody: { idLibros:number }):Observable<CalificacionLibro[]>{
    return this.http.post<CalificacionLibro[]>(`${this.endPoint}/calificaciones-libro`, requestBody, this.options);
  }

  public getCalificacionesByLibro(idLibros:number):Observable<calificacionesByLibroId[]>{

    return this.http.get<calificacionesByLibroId[]>(`${this.endPoint}/calificaciones-libro-id?idLibro=${idLibros}`, this.options);
  }
  
}
