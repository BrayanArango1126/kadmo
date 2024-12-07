import { Component } from '@angular/core';
import Cookies from 'js-cookie';
import { UsuarioService } from '../../services/usuario.service';
import Usuario from '../../interfaces/usuario';
import { LibrosService } from '../../services/libros.service';
import Libros from '../../interfaces/libros';
import { environment } from '../../../environments/environment';
import { DatoUsuarioService } from '../../services/dato-usuario.service';
import DatosUsuario from '../../interfaces/datosUsuario';
import * as cryptoJS from 'crypto-js';

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
  userDataNotFound:boolean = true;

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
    // Desencriptamos el id del usuario
    if(this.user == '0'){
      return;
    }
    this.user = cryptoJS.AES.decrypt(this.user, environment.cryptPassword).toString(cryptoJS.enc.Utf8);
    // Desencriptamos el id del usuario
    // this.user = cryptoJS.AES.decrypt(this.user, environment.cryptPassword).toString(cryptoJS.enc.Utf8);
    this.rol =cryptoJS.AES.decrypt(this.rol.toString(), environment.cryptPassword).toString(cryptoJS.enc.Utf8);
    // Le pasamos al servicio el id del usuario PARSEADO A tipo INT
    this._usuarioService.getUsuarioById(parseInt(this.user)).subscribe({
      next: (result) => {
        // Guardamos el objeto usuario en la variable usuario
        this.usuario = result;
        // Teniendo el objeto usuario, se lo pasamos a la función que obtiene los datos del usuario
        this.getDatoUsuario(this.usuario);
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
        this.userDataNotFound = err.ok;
      }
    });
  }

  public logOut(){
    localStorage.clear();
    Cookies.remove('authToken');
    window.location.href = '/store';
  }
}
