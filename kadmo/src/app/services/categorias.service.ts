import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import CategoriaLibro from '../interfaces/categoriaLibro';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CategoriasService {
    
  private endPoint:String = environment.endpoint + "/categoria-libro";
  constructor(private http:HttpClient) { }

  private header = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')
  .set('Accept', 'application/json');

  private options={
    headers:this.header
  }
  public getCategories():Observable<CategoriaLibro[]>{
    return this.http.get<CategoriaLibro[]>(`${this.endPoint}/categorias-libros`, this.options);
  }

  public getCategoriesById(idCategoriaLibro: number):Observable<CategoriaLibro[]>{
    return this.http.get<CategoriaLibro[]>(`${this.endPoint}/categoria-libro-id`, this.options);
  }

  public saveCategory(category: CategoriaLibro):Observable<CategoriaLibro>{
    return this.http.post<CategoriaLibro>(`${this.endPoint}/add-categoria-libro`, category, this.options);
  }

  public updateCategory(category: CategoriaLibro):Observable<CategoriaLibro>{
    return this.http.put<CategoriaLibro>(`${this.endPoint}/update-categoria-libro`, category, this.options);
  }
}


 
