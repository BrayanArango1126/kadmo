import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import LibroFavorito from '../interfaces/libroFavorito';
import { ResponseApi } from '../interfaces/response-api';
import Usuario from '../interfaces/usuario';
import { AuthTokenService } from './auth-token.service';

@Injectable({
  providedIn: 'root'
})
export class LibrosFavoritosService {

  private endPoint:string = environment.endpoint + '/libro-favorito';
  constructor(private http:HttpClient, private _authService:AuthTokenService) { }

  public getLibrosFavoritosByUser(usuario:Usuario):Observable<LibroFavorito[]>{
    return this.http.post<LibroFavorito[]>(`${this.endPoint}/libros-favoritos-id-usuario`, usuario
    //   , {
    //   headers: {
    //     Authorization: `Bearer ${this._authService.getToken()}`
    //   }
    // });
    );
  }

  public getLibrosFavoritos():Observable<LibroFavorito[]>{
    return this.http.get<LibroFavorito[]>(`${this.endPoint}/libros-favoritos`);
  }

  public getLibroFavoritoById(id:number):Observable<LibroFavorito>{
    return this.http.get<LibroFavorito>(`${this.endPoint}/libro-favorito/${id}`);
  }

  public saveLibroFavorito(libroFavorito:LibroFavorito):Observable<ResponseApi>{
    return this.http.post<ResponseApi>(`${this.endPoint}/add-libro-favorito`, libroFavorito);
  }

  public deleteLibroFavorito(id:number){
    return this.http.delete(`${this.endPoint}/delete-libro-favorito?idLibroFavorito=${id}`);
  }
}
