import { Component } from '@angular/core';
import { LibrosService } from '../../../../services/libros.service';
import Libros from '../../../../interfaces/libros';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrl: './libros.component.css'
})
export class LibrosComponent {

  booksList:Libros[] = [];


  constructor(private _librosService:LibrosService) { }

  ngOnInit(): void {
    this.getBooks();
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

}
