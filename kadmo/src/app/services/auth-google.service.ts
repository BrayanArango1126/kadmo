import { Injectable } from '@angular/core';
import { Auth, authState, GoogleAuthProvider, signInWithPopup } from '@angular/fire/auth';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGoogleService {

  
  constructor(private _auth:Auth){}

  public authState$():Observable<any>{
    return authState(this._auth);
  }

  public loginGoogle(){
    const provider = new GoogleAuthProvider();
    provider.setCustomParameters({prompt: 'select_account'});
    return signInWithPopup(this._auth, provider);
  }

}
