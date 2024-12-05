import { Component } from '@angular/core';
import Cookies from 'js-cookie';
import { UsuarioService } from '../../services/usuario.service';
import Usuario from '../../interfaces/usuario';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { LibrosService } from '../../services/libros.service';
import Libros from '../../interfaces/libros';
import { debounceTime, map, Observable, startWith } from 'rxjs';
import { MatAutocompleteSelectedEvent } from '@angular/material/autocomplete';

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

  filteredBooks: Libros[] = [];

  constructor(private _usuarioService: UsuarioService, private _libroService: LibrosService) {
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
        console.log(result);
        this.listAllBooks = result;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public getUsuer(){
    if(this.user == '0'){
      return;
    }
    this._usuarioService.getUsuarioById(parseInt(this.user)).subscribe({
      next: (result) => {
        this.usuario = result;
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
