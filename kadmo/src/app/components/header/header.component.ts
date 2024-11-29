import { Component } from '@angular/core';
import Cookies from 'js-cookie';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  user = localStorage.getItem('user') || 0;
  rol = localStorage.getItem('rol') || 0;
  
  constructor() { }

  ngOnInit(): void {
  }
  
  public logOut(){
    localStorage.clear();
    Cookies.remove('authToken');
    window.location.href = '/store';
  }
}
