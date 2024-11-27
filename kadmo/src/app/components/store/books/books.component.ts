import { Component } from '@angular/core';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrl: './books.component.css'
})
export class BooksComponent {
  books:any = [
    {
      title: 'Harry Potter y el Prisionero de Azkaban',
      img: 'img/portada-1.jpg',
      pages: 384,
    },
    {
      title: 'Cien años de soledad',
      img: 'img/portada-2.jpg',
      pages: 496,
    },
    {
      title: 'La Vorágine',
      img: 'img/portada-3.jpg',
      pages: 180,
    },
    {
      title: 'Inteligencia Artificial. Investigaciones, aplicaciones y avances',
      img: 'img/portada-4.jpg',
      pages: 288,
    },
    {
      title: 'Harry Potter y el Prisionero de Azkaban',
      img: 'img/portada-1.jpg',
      pages: 384,
    },
    {
      title: 'Cien años de soledad',
      img: 'img/portada-2.jpg',
      pages: 496,
    },
    {
      title: 'La Vorágine',
      img: 'img/portada-3.jpg',
      pages: 180,
    },
    {
      title: 'Inteligencia Artificial. Investigaciones, aplicaciones y avances',
      img: 'img/portada-4.jpg',
      pages: 288,
    }
  ]

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
