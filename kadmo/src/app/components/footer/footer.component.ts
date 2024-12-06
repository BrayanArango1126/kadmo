import { Component } from '@angular/core';
import { environment } from '../../../environments/environment';
import * as cryptoJS from 'crypto-js';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  
  rol = localStorage.getItem('rol') || 0;

  constructor() {}

  ngOnInit(): void {
    this.getRol();
  }
  
  private getRol(){
    // Desencriptamos el rol del usuario
    this.rol = cryptoJS.AES.decrypt(this.rol.toString(), environment.cryptPassword).toString(cryptoJS.enc.Utf8);
    console.log(this.rol);
  }
}
