import { Component } from '@angular/core';
import Cookies from 'js-cookie';
import { UsuarioService } from '../../services/usuario.service';
import Usuario from '../../interfaces/usuario';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { LibrosService } from '../../services/libros.service';
import Libros from '../../interfaces/libros';
import { debounceTime, map, Observable, startWith } from 'rxjs';
import { environment } from '../../../environments/environment';
import cryptoJS from 'crypto-js';
import { DatoUsuarioService } from '../../services/dato-usuario.service';
import DatosUsuario from '../../interfaces/datosUsuario';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  user = localStorage.getItem('user') || '0';
  rol = localStorage.getItem('rol') || 0;

  listAllBooks:Libros[] = [];
  usuario!:Usuario;
  datosUsuario!:DatosUsuario;

  filteredBooks: Libros[] = [];

  constructor(private _usuarioService: UsuarioService, private _libroService: LibrosService, private _datoUsuarioService:DatoUsuarioService) {
  }

  ngOnInit(): void {
    this.getUsuer();
    this.getAllBooks();
  }

  private filterBooks(value: string): any[] {
    const filterValue = value.toLowerCase();
    return this.listAllBooks.filter(book => book.nombre.toLowerCase().includes(filterValue));
  }

  public getAllBooks(){
    this._libroService.getLibros().subscribe({
      next: (result) => {
        this.listAllBooks = result;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public getUsuer(){
    this.user = cryptoJS.AES.decrypt(this.user, environment.cryptPassword).toString(cryptoJS.enc.Utf8);
    if(this.user == '0'){
      return;
    }
    this._usuarioService.getUsuarioById(parseInt(this.user)).subscribe({
      next: (result) => {
        this.getDatoUsuario(result);
        this.usuario = result;
        console.log(this.usuario)
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
  
  public getDatoUsuario(user:Usuario){

    this._datoUsuarioService.getDatoUsuarioById(user).subscribe({
      next: (result) => {
        this.datosUsuario = result;
        console.log(this.datosUsuario)
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
  public logOut(){
    localStorage.clear();
    Cookies.remove('authToken');
    window.location.href = '/store';
  }
}
