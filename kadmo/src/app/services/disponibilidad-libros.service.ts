import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import DisponibilidadLibro from '../interfaces/disponibilidadLibro';

@Injectable({
  providedIn: 'root'
})
export class DisponibilidadLibrosService {

  private endpoint = environment.endpoint + '/disponibilidad-libro';
  constructor(private http:HttpClient) { }

  public getDisponibilidadLibros():Observable<DisponibilidadLibro[]>{
    return this.http.get<DisponibilidadLibro[]>(`${this.endpoint}/disponibilidad-libros`);
  }
}
