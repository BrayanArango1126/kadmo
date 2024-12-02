import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import EstadoLibro from '../interfaces/estadoLibro';

@Injectable({
  providedIn: 'root'
})
export class EstadosLibrosService {

  private endPoint:string = environment.endpoint + '/estados-libro';
  constructor(private http:HttpClient) { }

  public getEstadosLibros():Observable<EstadoLibro[]>{
    return this.http.get<EstadoLibro[]>(`${this.endPoint}/estados-libros`);
  }
}
