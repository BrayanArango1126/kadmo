import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import Chatbox from '../interfaces/chatbox';
import { Observable } from 'rxjs';
import { ResponseApi } from '../interfaces/response-api';

@Injectable({
  providedIn: 'root',
})
export class ChatboxService {
  private chatboxUrl = environment.chatboxUrl;
  constructor(private http: HttpClient) {}

  getChatBoxAnswer(chatbox: Chatbox): Observable<ResponseApi> {
    return this.http.post<ResponseApi>(`${this.chatboxUrl}/chatbot`, chatbox);
  }
}
