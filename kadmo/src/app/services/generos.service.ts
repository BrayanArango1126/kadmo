import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import Genero from '../interfaces/genero';

@Injectable({
  providedIn: 'root'
})
export class GenerosService {

  private endPoint:string = environment.endpoint + '/genero';
  constructor(private http:HttpClient) { }

  public getGeneros():Observable<Genero>{
    return this.http.get<Genero>(`${this.endPoint}/generos`);
  }
}
