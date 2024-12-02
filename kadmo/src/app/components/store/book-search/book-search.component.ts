import { Component } from '@angular/core';
import calificacionesByLibroId from '../../../interfaces/calificacionesByLibroId';
import { CalificacionService } from '../../../services/calificacion.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-search',
  templateUrl: './book-search.component.html',
  styleUrl: './book-search.component.css'
})
export class BookSearchComponent {

  noteList:calificacionesByLibroId[] = [];


  constructor(private _calificacionService:CalificacionService, private _activatedRoute: ActivatedRoute) {} 
  
  async ngOnInit():Promise<void> {
    const idLibro = this._activatedRoute.snapshot.params['id'];
  if (idLibro) {
    this.getCalificaciones(idLibro);
  }
  }


  public getCalificaciones(libro:number){
    this._calificacionService.getCalificacionesByLibro(libro).subscribe({
      next: (data) => {
        
        this.noteList = data;
        console.log(data);
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
}
