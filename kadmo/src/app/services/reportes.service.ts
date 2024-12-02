import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Transaccion from '../interfaces/transaccion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportesService {

  constructor(private http:HttpClient) { }

  private endPoint = `${environment.endpoint}/transaccion`;
  
  private header = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')
  .set('Accept', 'application/json');

  private options={
    headers:this.header
  }

  getAllTransacciones(): Observable<Transaccion[]> {
    return this.http.get<Transaccion[]>(`${this.endPoint}/transacciones`, this.options);
  }

  getTransaccionById(idtransaccion: number): Observable<Transaccion> {
    return this.http.get<Transaccion>(`${this.endPoint}/transaccion/${idtransaccion}`, this.options);
  }
}
