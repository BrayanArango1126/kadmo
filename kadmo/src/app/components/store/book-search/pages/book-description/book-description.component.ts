import { Component } from '@angular/core';

@Component({
  selector: 'app-book-description',
  templateUrl: './book-description.component.html',
  styleUrl: './book-description.component.css',
  standalone: false

})
export class BookDescriptionComponent {

  chapters:any = [
    {
      title: 'Introducción a React',
    },
    {
      title: 'Configuración',
    },
    {
      title: 'Chapter 3',
    },
    {
      title: 'Configuración enrutamiento',
    },
    {
      title: 'Estilización React',
    },
    {
      title: 'Manejo Formularios',
    },
    {
      title: 'Optimización y rendimiento',
    },
    {
      title: 'Pruebas en React',
    }

  ]
}
