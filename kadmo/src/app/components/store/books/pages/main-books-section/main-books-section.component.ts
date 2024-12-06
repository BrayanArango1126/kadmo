import { Component, OnInit } from '@angular/core';
import { LibrosService } from '../../../../../services/libros.service';
import Libros from '../../../../../interfaces/libros';
import { LibrosPublicadosService } from '../../../../../services/libros-publicados.service';
import LibroPublicado from '../../../../../interfaces/libroPublicado';
import { LibrosFavoritosService } from '../../../../../services/libros-favoritos.service';
import LibroFavorito from '../../../../../interfaces/libroFavorito';
import Usuario from '../../../../../interfaces/usuario';
import { LibrosSharedFiltersService } from '../../../../../services/libros-shared-filters.service';
import { environment } from '../../../../../../environments/environment';
import * as CryptoJS from 'crypto-js';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-books-section',
  templateUrl: './main-books-section.component.html',
  styleUrl: './main-books-section.component.css'
})
export class MainBooksSectionComponent implements OnInit {

  idLibro:string = '';

  booksList:Libros[] = [];

  booksListFiltered:Libros[] = [];

  bookListPublished:LibroPublicado[] = [];

  favoritesBooks:LibroFavorito[] = [];

  cantLibros:number = 0;

  constructor(
    private _librosService:LibrosService,
    private _librosPublicadosService:LibrosPublicadosService,
    private _librosFavoritosService:LibrosFavoritosService,
    private _librosSharedFiltersService:LibrosSharedFiltersService,
    private router: Router
  ) { }

  ngOnInit(): void {
    //this.getBooks();
    this.getBooksPublicados();
    this.getFavoritesBooks();
    this.getBooksFiltered();
  }

  public getBooksFiltered(){
    this._librosSharedFiltersService.libros$.subscribe((libros) => {
      this.booksListFiltered = libros; // Escucha los cambios en la lista de libros
    });
  }

  public goToBookDetails(idBook:number){
    this.idLibro = idBook.toString();
    this.idLibro = this.encrypt(this.idLibro);
    window.location.href = `/store/book/${this.idLibro}`;
  }

  public compareBooks(idBook:number){
    let idUser = localStorage.getItem('user') || '0';
    if(idUser == '0'){
      return;
    }
    let book = this.favoritesBooks.find((book) => book.libro.idLibros == idBook);
    if(book){
      return "custom-class-active-favorite";
    }
    return "custom-class-inactive-favorite";
  }

  public getFavoritesBooks(){
    let idUser = localStorage.getItem('user') || '0';
    if(idUser == '0'){
      return;
    }
    const usuario:Usuario = {
      idUsuario: parseInt(idUser),
      correo: '',
      contraseña: '',
      rol: {
        idRol: 0
      }
    };
    this._librosFavoritosService.getLibrosFavoritosByUser(usuario).subscribe({
      next: (data) => {
        this.favoritesBooks = data;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public getBooksPublicados(){
    this._librosPublicadosService.getLibrosPublicados().subscribe({
      next: (data) => {
        this.bookListPublished = data;
        this.countCantLibros();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public getBooks(){
    this._librosService.getLibros().subscribe({
      next: (data) => {
        this.booksList = data;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public saveBook(book:Libros){
    let idUser = localStorage.getItem('user');
    if(idUser == '0' || idUser == null){
      alert("No puedes guardar libros si no has iniciado sesión");
      return;
    }

    let libroFav = this.favoritesBooks.find((libro) => libro.libro.idLibros == book.idLibros);
    if(libroFav != undefined){
      console.log("aqui toy 2");
      const libroFavorito: LibroFavorito = {
        idLibroFavorito: libroFav.idLibroFavorito,
        libro: {
          idLibros: 0
        },
        usuario: {
          idUsuario: 0
        }
      };
      this.deleteBookFavorite(libroFavorito);
      return;
    }else{
      console.log("aqui toy ");
      const libroFavorito: LibroFavorito = {
        idLibroFavorito: 0,
        libro: {
          idLibros: book.idLibros
        },
        usuario: {
          idUsuario: parseInt(idUser)
        }
      };
      this._librosFavoritosService.saveLibroFavorito(libroFavorito).subscribe({
        next: (data) => {
          alert(data.message);
          this.getFavoritesBooks();
          this.getBooksPublicados();
        },
        error: (err) => {
          console.log(err);
        }
      });
    }
  }

  public deleteBookFavorite(libroFav:LibroFavorito){
    this._librosFavoritosService.deleteLibroFavorito(libroFav.idLibroFavorito).subscribe({
      next: (data) => {
        console.log("Legue aqui");	
        alert("Libro eliminado de favoritos");
        this.getFavoritesBooks();
        this.getBooksPublicados();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public countCantLibros(){
    this.cantLibros = this.bookListPublished.length;
  }

  public encrypt(idLibro: string): string { 
    const safeId = encodeURIComponent(CryptoJS.AES.encrypt(idLibro, environment.cryptPassword).toString());
    return safeId;
  }

}
