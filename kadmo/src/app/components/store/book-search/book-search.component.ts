import { Component } from '@angular/core';
import calificacionesByLibroId from '../../../interfaces/calificacionesByLibroId';
import { CalificacionService } from '../../../services/calificacion.service';
import { ActivatedRoute } from '@angular/router';
import CalificacionLibro from '../../../interfaces/calificacionLibro';
import { LibrosService } from '../../../services/libros.service';
import Libros from '../../../interfaces/libros';
import { environment } from '../../../../environments/environment';
import * as CryptoJS from 'crypto-js';

@Component({
  selector: 'app-book-search',
  templateUrl: './book-search.component.html',
  styleUrl: './book-search.component.css'
})
export class BookSearchComponent {

  noteList:calificacionesByLibroId[] = [];
  idRoute:string = '';
  idLibro:number=0;

  calificacionesList:CalificacionLibro[] = [];


  selectedCalification:CalificacionLibro[] = [];

  librosList:Libros[] = [];
  libro:Libros[] = [];

  selectedBook:Libros = {
    idLibros: 0,
      nombre: '',
      autor: '',
      precio: 0,
      descripcion: '',
      estadosLibro: {
        idEstadosLibros: 0,
        estado: ''
      },
      categoriasLibro: {
        idCategoriaLibro: 0,
        categoria: ''
      },
      disponibilidadLibro: {
        idDisponibilidadLibro: 0,
        disponibilidad: ''
      }
  };


  constructor(private _calificacionService:CalificacionService, private _activatedRoute: ActivatedRoute, private _librosService:LibrosService) {
    this.idRoute = this._activatedRoute.snapshot.params['id'];
    this.decriptRoute(this.idRoute);
  } 

  ngOnInit():void {
    this.getAllCalificaciones();
    this.getAllBooks();
  }

  private decriptRoute(id:string){
    const encId = decodeURIComponent(id);
    this.idLibro = parseInt(CryptoJS.AES.decrypt(encId, environment.cryptPassword).toString(CryptoJS.enc.Utf8));
    // console.log(this.idLibro);
  }
  

  public getAllCalificaciones(){
    this._calificacionService.getAllCalificaciones().subscribe({
      next: (data) => {
        this.calificacionesList = data;
        console.log(this.libro)
        this.selectCalificacionByIdLibro(this.idLibro);
        this.libro.push(data[0].libro);
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public getAllBooks(){
    this._librosService.getLibros().subscribe({
      next: (data) => {
        this.librosList = data;
        this.selectBookById(this.idLibro);
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  // public getAllBooks(){
  //   this._librosService.getLibros().subscribe({
  //     next: (data) => {
  //       this.librosList = data;
  //       this.selectBookById(this.idLibro);
  //     },
  //     error: (err) => {
  //       console.log(err);
  //     }
  //   });
  // }

  public selectCalificacionByIdLibro(idLibro:number){
    this.selectedCalification = this.calificacionesList.filter(calificacion => calificacion.libro.idLibros == idLibro);
  }

  public selectBookById(idLibro:number){
    this.selectedBook = this.librosList.find(libro => libro.idLibros == idLibro) || this.selectedBook;
  }

}
