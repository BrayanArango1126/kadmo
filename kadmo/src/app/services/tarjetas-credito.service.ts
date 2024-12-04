import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import TarjetaCredito from '../interfaces/tarjetaCredito';
import Usuario from '../interfaces/usuario';
import { ResponseApi } from '../interfaces/response-api';

@Injectable({
  providedIn: 'root'
})
export class TarjetasCreditoService {

  private endPoint:string = environment.endpoint + '/tarjeta-credito';
  constructor(private http:HttpClient) { }

  public getAllTarjetasCredito():Observable<TarjetaCredito[]> {
    return this.http.get<TarjetaCredito[]>(`${this.endPoint}/tarjetas-credito`);
  }

  public getTarjetaCreditoById(idTarjetaCredito:number):Observable<TarjetaCredito> {
    return this.http.get<TarjetaCredito>(`${this.endPoint}/tarjeta-credito-id/${idTarjetaCredito}`);
  }

  public createTarjetaCredito(tarjetaCredito:TarjetaCredito):Observable<ResponseApi> {
    return this.http.post<ResponseApi>(`${this.endPoint}/add-tarjeta-credito`, tarjetaCredito);
  }

  public updateTarjetaCredito(tarjetaCredito:TarjetaCredito):Observable<TarjetaCredito> {
    return this.http.put<TarjetaCredito>(`${this.endPoint}/update-tarjeta-credito`, tarjetaCredito);
  }

  public getTarjetasCreditoByUserId(usuario:Usuario):Observable<TarjetaCredito[]> {
    return this.http.post<TarjetaCredito[]>(`${this.endPoint}/tarjeta-credito-id-usuario`, usuario);
  }
}
