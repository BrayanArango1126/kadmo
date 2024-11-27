import { Component } from '@angular/core';

@Component({
  selector: 'app-aside-books-section',
  templateUrl: './aside-books-section.component.html',
  styleUrl: './aside-books-section.component.css'
})
export class AsideBooksSectionComponent {

  categories:any = [
    {
      name: 'Acción',
      value: 1
    },
    {
      name: 'Siniestro',
      value: 2
    },
    {
      name: 'Terror',
      value: 3
    },
    {
      name: 'Programación',
      value: 4
    },
    {
      name: 'Romance',
      value: 5
    },
    {
      name: 'Suspenso',
      value: 6
    },
    {
      name: 'Aventura',
      value: 7
    },
    {
      name: 'Comedia',
      value: 8
    },
  ]
}
