import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import Login from '../interfaces/login';
import { Observable } from 'rxjs';
import { ResponseApi } from '../interfaces/response-api';

@Injectable({
  providedIn: 'root',
})
export class LogInService {
  private endPoint: String = environment.endpoint + '/login';
  constructor(private http: HttpClient) {}

  public logIn(data: Login): Observable<ResponseApi> {
    return this.http.post<ResponseApi>(`${this.endPoint}`, data);
  }
  public logInFace(data: Login): Observable<ResponseApi> {
    return this.http.post<ResponseApi>(`${this.endPoint}-face`, data);
  }
}
