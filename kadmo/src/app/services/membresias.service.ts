import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import Membresia from '../interfaces/membresia';
import { ResponseApi } from '../interfaces/response-api';

@Injectable({
  providedIn: 'root'
})
export class MembresiasService {

  private endPoint:string = environment.endpoint + '/membresia';
  constructor(private http:HttpClient) { }

  public getAllMembresias():Observable<Membresia[]>{
    return this.http.get<Membresia[]>(`${this.endPoint}/membresias`);
  }

  public getMembresiaById(idMembresia:number):Observable<Membresia>{
    return this.http.get<Membresia>(`${this.endPoint}/membresia/${idMembresia}`);
  }

  public createMembresia(membresia:Membresia):Observable<Membresia>{
    return this.http.post<Membresia>(`${this.endPoint}/add-membresia`, membresia);
  }

}
