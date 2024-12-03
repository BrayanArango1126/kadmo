import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import Rol from '../interfaces/rol';

@Injectable({
  providedIn: 'root'
})
export class RolesService {

  private endPoint = environment.endpoint + '/rol';

  constructor(private http:HttpClient) { }

  public getRoles():Observable<Rol[]>{
    return this.http.get<Rol[]>(`${this.endPoint}/roles`);
  }

}
