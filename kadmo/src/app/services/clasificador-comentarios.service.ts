import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import Clasificacion from '../interfaces/clasificacion';
import { Observable } from 'rxjs';
import { ResponseApi } from '../interfaces/response-api';
import CalificacionLibro from '../interfaces/calificacionLibro';

@Injectable({
  providedIn: 'root',
})
export class ClasificadorComentariosService {
  private clasificadorUrl = environment.clasificacionUrl;
  constructor(private http: HttpClient) {}

  getClasificacion(comentario: Clasificacion): Observable<ResponseApi> {
    return this.http.post<ResponseApi>(
      `${this.clasificadorUrl}/emocion`,
      comentario
    );
  }
}
