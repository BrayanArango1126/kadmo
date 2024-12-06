import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import Transaccion from '../interfaces/transaccion';

@Injectable({
  providedIn: 'root'
})
export class TransaccionesService {

  private endPoint = environment.endpoint + '/transaccion';
  constructor(private http:HttpClient) { }

  public getTransacciones():Observable<Transaccion[]>{
    return this.http.get<Transaccion[]>(`${this.endPoint}/transacciones`);
  }

  public addTransaccion(transaccion:Transaccion):Observable<Transaccion>{
    return this.http.post<Transaccion>(`${this.endPoint}/add-transaccion`, transaccion);
  }

  public getTransaccionExcel(fechaInicio:string, fechaFin:string):Observable<Blob>{
    return this.http.get(`${this.endPoint}/reporte?fechaInicio=${fechaInicio}&fechaFin=${fechaFin}`, {responseType: 'blob'});
  }
}
