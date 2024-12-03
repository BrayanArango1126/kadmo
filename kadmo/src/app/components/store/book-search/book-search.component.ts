import { Component } from '@angular/core';
import calificacionesByLibroId from '../../../interfaces/calificacionesByLibroId';
import { CalificacionService } from '../../../services/calificacion.service';
import { ActivatedRoute } from '@angular/router';
import CalificacionLibro from '../../../interfaces/calificacionLibro';

@Component({
  selector: 'app-book-search',
  templateUrl: './book-search.component.html',
  styleUrl: './book-search.component.css'
})
export class BookSearchComponent {


  noteList:calificacionesByLibroId[] = [];
  idLibro:number = 0;

  calificacionesList:CalificacionLibro[] = [];


  selectedCalification:CalificacionLibro[] = [];


  constructor(private _calificacionService:CalificacionService, private _activatedRoute: ActivatedRoute) {
    this.idLibro = this._activatedRoute.snapshot.params['id'];
  } 
  
  ngOnInit():void {
    this.getAllCalificaciones();
  }

  public getAllCalificaciones(){
    this._calificacionService.getAllCalificaciones().subscribe({
      next: (data) => {
        this.calificacionesList = data;
        this.selectCalificacionByIdLibro(this.idLibro);
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
