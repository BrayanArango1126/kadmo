import { Component } from '@angular/core';

@Component({
  selector: 'app-main-books-section',
  templateUrl: './main-books-section.component.html',
  styleUrl: './main-books-section.component.css'
})
export class MainBooksSectionComponent {
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
}
