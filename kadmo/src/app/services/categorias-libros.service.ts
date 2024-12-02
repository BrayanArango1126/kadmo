import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import CategoriaLibro from '../interfaces/categoriaLibro';

@Injectable({
  providedIn: 'root'
})
export class CategoriasLibrosService {

  private endPoint:string = environment.endpoint + '/categoria-libro';
  constructor(private http:HttpClient) { }

  public getCategoriasLibros():Observable<CategoriaLibro[]>{
    return this.http.get<CategoriaLibro[]>(`${this.endPoint}/categorias-libros`);
  }
}
