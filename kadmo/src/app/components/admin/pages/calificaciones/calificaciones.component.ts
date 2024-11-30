import { Component } from '@angular/core';
import CalificacionLibro from '../../../../interfaces/calificacionLibro';
import { CalificacionService } from '../../../../services/calificacion.service';
import Libros from '../../../../interfaces/libros';
import { LibrosService } from '../../../../services/libros.service';

@Component({
  selector: 'app-calificaciones',
  templateUrl: './calificaciones.component.html',
  styleUrl: './calificaciones.component.css'
})
export class CalificacionesComponent {
  // ratesList:CalificacionLibro[] = [];


  // constructor(private _calificacionService:CalificacionService) { }

  // ngOnInit(): void {
  //   this.getRatings();
  // }

  // public getRatings(){
  //   this._calificacionService.getCalificaciones().subscribe({
  //     next: (data) => {
  //       this.ratesList = data;
  //     },
  //     error: (err) => {
  //       console.log(err);
  //     }
  //   });
  // }
  
  calificacionesList: CalificacionLibro[] = [];
  booksList: Libros[] = [];
  mergedCalificaciones: any[] = []; // Will hold the merged data with book names

  constructor(
    private _calificacionService: CalificacionService,
    private _librosService: LibrosService
  ) {}

  ngOnInit(): void {
    this.getBooksAndCalificaciones();
  }

  // Fetch books and calificaciones and merge the data
  public getBooksAndCalificaciones() {
    this._librosService.getLibros().subscribe({
      next: (books) => {
        this.booksList = books;

        this._calificacionService.getCalificaciones({ idLibros: 0 }).subscribe({
          next: (calificaciones) => {
            this.calificacionesList = calificaciones;

            // Merge the book name into each calificacion object
            this.mergedCalificaciones = this.calificacionesList.map((calificacion) => {
              const book = this.booksList.find(
                (book) => book.idLibros === calificacion.libro.idLibros
              );

              return {
                ...calificacion,
                libroNombre: book ? book.nombre : 'Libro no encontrado',
              };
            });
          },
          error: (err) => console.error(err),
        });
      },
      error: (err) => console.error(err),
    });
  }
}
