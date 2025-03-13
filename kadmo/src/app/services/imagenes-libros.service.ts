import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import ImagenesLibros from '../interfaces/imagenesLibros';
import { ResponseApi } from '../interfaces/response-api';
import Libros from '../interfaces/libros';

@Injectable({
  providedIn: 'root',
})
export class ImagenesLibrosService {
  private endPoint = environment.endpoint + '/imagen-libro';

  constructor(private http: HttpClient) {}

  public getImagenesLibros(): Observable<ImagenesLibros[]> {
    return this.http.get<ImagenesLibros[]>(`${this.endPoint}/imagenes-libros`);
  }

  public getImagenLibroId(id: number): Observable<ImagenesLibros> {
    return this.http.get<ImagenesLibros>(
      `${this.endPoint}/imagen-libro-id/${id}`
    );
  }

  public getImagenLibroIdLibro(libro: Libros): Observable<ImagenesLibros> {
    return this.http.post<ImagenesLibros>(
      `${this.endPoint}/imagen-by-id-libro`,
      libro
    );
  }

  public addImagenLibro(file: File, idLibro: number): Observable<ResponseApi> {
    const formData = new FormData();
    formData.append('file', file);
    formData.append('idLibro', idLibro.toString());
    return this.http.post<ResponseApi>(
      `${this.endPoint}/add-imagen-libro`,
      formData
    );
  }
}
