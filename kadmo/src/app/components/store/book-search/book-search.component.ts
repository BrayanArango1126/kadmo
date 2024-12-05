import { Component } from '@angular/core';
import calificacionesByLibroId from '../../../interfaces/calificacionesByLibroId';
import { CalificacionService } from '../../../services/calificacion.service';
import { ActivatedRoute } from '@angular/router';
import CalificacionLibro from '../../../interfaces/calificacionLibro';
import { environment } from '../../../../environments/environment';
import Libros from '../../../interfaces/libros';
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

  libro:Libros[] = [];

  constructor(private _calificacionService:CalificacionService, private _activatedRoute: ActivatedRoute) {
    this.idRoute = this._activatedRoute.snapshot.params['id'];
    this.decriptRoute(this.idRoute);
  } 

  ngOnInit():void {
    this.getAllCalificaciones();
  }

  private decriptRoute(id:string){
    const encId = decodeURIComponent(id);
    this.idLibro = parseInt(CryptoJS.AES.decrypt(encId, environment.cryptPassword).toString(CryptoJS.enc.Utf8));
    console.log(this.idLibro);
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

  public selectCalificacionByIdLibro(idLibro:number){
    this.selectedCalification = this.calificacionesList.filter(calificacion => calificacion.libro.idLibros == idLibro);
  }

}
