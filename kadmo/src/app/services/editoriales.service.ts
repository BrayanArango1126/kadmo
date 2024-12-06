import { Injectable } from '@angular/core';
import Editorial from '../interfaces/editoriales';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EditorialesService {

  constructor(private http:HttpClient) { }

  private endPoint = `${environment.endpoint}/editorial`;
  
  private header = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')
  .set('Accept', 'application/json');

  private options={
    headers:this.header
  }

  getAllEditoriales(): Observable<Editorial[]> {
    return this.http.get<Editorial[]>(`${this.endPoint}/editoriales`, this.options);
  }
  
  getEditorialById(requestBody: { "idEditoriales": number}):Observable<Editorial> {
    return this.http.post<Editorial>(`${this.endPoint}/editorial-id`, requestBody, this.options);
  }

  addEditorial(request:Editorial):Observable<Editorial>{
    return this.http.post<Editorial>(`${this.endPoint}/add-editorial`, request, this.options);
  }

  updateEditorial(request:Editorial):Observable<Editorial>{
    return this.http.put<Editorial>(`${this.endPoint}/update-editorial`, request, this.options);
  }
}