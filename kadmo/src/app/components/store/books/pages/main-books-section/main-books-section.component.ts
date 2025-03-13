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
import * as cryptoJS from 'crypto-js';
import { ChatboxService } from '../../../../../services/chatbox.service';
import Chatbox from '../../../../../interfaces/chatbox';
import * as bootstrap from 'bootstrap';
import { ImagenesLibrosService } from '../../../../../services/imagenes-libros.service';
import ImagenesLibros from '../../../../../interfaces/imagenesLibros';

@Component({
  selector: 'app-main-books-section',
  templateUrl: './main-books-section.component.html',
  styleUrl: './main-books-section.component.css',
})
export class MainBooksSectionComponent implements OnInit {
  //Paginación
  items: any[] = []; // Lista completa de elementos
  currentPage: number = 1; // Página actual
  itemsPerPage: number = 12; // Elementos por página
  totalItems: number = 0; // Total de elementos
  chatbot!: Chatbox;
  questionAI: string = '';
  responseAI = '';

  idLibro: string = '';

  imagenLibro!: ImagenesLibros;
  listAllImages: ImagenesLibros[] = [];

  booksList: Libros[] = [];

  booksListFiltered: Libros[] = [];

  bookListPublished: LibroPublicado[] = [];

  favoritesBooks: LibroFavorito[] = [];

  cantLibros: number = 0;

  constructor(
    private _librosService: LibrosService,
    private _librosPublicadosService: LibrosPublicadosService,
    private _librosFavoritosService: LibrosFavoritosService,
    private _librosSharedFiltersService: LibrosSharedFiltersService,
    private router: Router,
    private _imagenesLibrosService: ImagenesLibrosService,
    private _chatboxService: ChatboxService
  ) {}

  ngOnInit(): void {
    //this.getBooks();
    this.getBooksPublicados();
    this.getFavoritesBooks();
    this.getBooksFiltered();
    this.getAllImages();
  }

  public getBooksFiltered() {
    this._librosSharedFiltersService.libros$.subscribe((libros) => {
      this.booksListFiltered = libros; // Escucha los cambios en la lista de libros
    });
  }

  public goToBookDetails(idBook: number) {
    this.idLibro = idBook.toString();
    this.idLibro = this.encrypt(this.idLibro);
    window.location.href = `/store/book/${this.idLibro}`;
  }

  public openModalAI(idBook: Libros) {
    if (idBook.idLibros) {
      this.chatbot = {
        idLibro: idBook.idLibros,
        pregunta: '',
      };
    }
    const modalElement = document.getElementById('openCardModal');
    if (modalElement) {
      const modal = new bootstrap.Modal(modalElement);
      modal.show();
    } else {
      console.error('Modal element not found');
    }
  }

  public askToAI() {
    this.chatbot = {
      idLibro: this.chatbot.idLibro,
      pregunta: this.questionAI,
    };
    this._chatboxService.getChatBoxAnswer(this.chatbot).subscribe({
      next: (data) => {
        this.responseAI = data.message;
      },
      error: (err) => {
        this.responseAI = 'No se pudo obtener respuesta';
      },
    });
  }

  public compareBooks(idBook: number) {
    let idUser = localStorage.getItem('user') || '0';
    idUser = cryptoJS.AES.decrypt(idUser, environment.cryptPassword).toString(
      cryptoJS.enc.Utf8
    );
    if (idUser == '0') {
      return;
    }
    let book = this.favoritesBooks.find(
      (book) => book.libro.idLibros == idBook
    );
    if (book) {
      return 'custom-class-active-favorite';
    }
    return 'custom-class-inactive-favorite';
  }

  public getFavoritesBooks() {
    let idUser = localStorage.getItem('user') || '0';
    if (idUser == '0') {
      return;
    }
    idUser = cryptoJS.AES.decrypt(idUser, environment.cryptPassword).toString(
      cryptoJS.enc.Utf8
    );
    const usuario: Usuario = {
      idUsuario: parseInt(idUser),
      correo: '',
      contraseña: '',
      rol: {
        idRol: 0,
      },
    };
    this._librosFavoritosService.getLibrosFavoritosByUser(usuario).subscribe({
      next: (data) => {
        this.favoritesBooks = data;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  onPageChange(page: number): void {
    this.currentPage = page; // Cambia la página actual
  }

  public getBooksPublicados() {
    this._librosPublicadosService.getLibrosPublicados().subscribe({
      next: (data) => {
        this.bookListPublished = data;
        this.totalItems = this.bookListPublished.length;
        this.countCantLibros();
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  public getBooks() {
    this._librosService.getLibros().subscribe({
      next: (data) => {
        this.booksList = data;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  public saveBook(book: Libros) {
    let idUser = localStorage.getItem('user') || '0';
    if (idUser == '0') {
      alert('No puedes guardar libros si no has iniciado sesión');
      return;
    }
    idUser = cryptoJS.AES.decrypt(idUser, environment.cryptPassword).toString(
      cryptoJS.enc.Utf8
    );
    // console.log(idUser);

    let libroFav = this.favoritesBooks.find(
      (libro) => libro.libro.idLibros == book.idLibros
    );
    if (libroFav != undefined) {
      const libroFavorito: LibroFavorito = {
        idLibroFavorito: libroFav.idLibroFavorito,
        libro: {
          idLibros: 0,
        },
        usuario: {
          idUsuario: 0,
        },
      };
      this.deleteBookFavorite(libroFavorito);
      return;
    } else {
      const libroFavorito: LibroFavorito = {
        idLibroFavorito: 0,
        libro: {
          idLibros: book.idLibros,
        },
        usuario: {
          idUsuario: parseInt(idUser),
        },
      };
      this._librosFavoritosService.saveLibroFavorito(libroFavorito).subscribe({
        next: (data) => {
          alert(data.message);
          this.getFavoritesBooks();
          this.getBooksPublicados();
        },
        error: (err) => {
          console.log(err);
        },
      });
    }
  }

  public deleteBookFavorite(libroFav: LibroFavorito) {
    this._librosFavoritosService
      .deleteLibroFavorito(libroFav.idLibroFavorito)
      .subscribe({
        next: (data) => {
          alert('Libro eliminado de favoritos');
          this.getFavoritesBooks();
          this.getBooksPublicados();
        },
        error: (err) => {
          console.log(err);
        },
      });
  }

  public getAllImages() {
    this._imagenesLibrosService.getImagenesLibros().subscribe({
      next: (data) => {
        this.listAllImages = data;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  public getImageByIdLibro(idLibro: number) {
    let url = this.listAllImages.find(
      (imagen) => imagen.libro.idLibros == idLibro
    );
    if (url) {
      return 'http://localhost:8080' + url.url;
    }
    return 'assets/images/book-placeholder.png';
  }

  public countCantLibros() {
    this.cantLibros = this.bookListPublished.length;
  }

  public encrypt(idLibro: string): string {
    const safeId = encodeURIComponent(
      CryptoJS.AES.encrypt(idLibro, environment.cryptPassword).toString()
    );
    return safeId;
  }
}
