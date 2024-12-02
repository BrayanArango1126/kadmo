import { Component } from '@angular/core';

@Component({
  selector: 'app-categories-section',
  templateUrl: './categories-section.component.html',
  styleUrl: './categories-section.component.css'
})
export class CategoriesSectionComponent {
  books:any = [
    {
      title: 'Suspenso',
      img: 'img/portada-6.jpg',
      cantidad: 100,
    },
    {
      title: 'Teror',
      img: 'img/portada-4.jpg',
      cantidad: 60,
    },
    {
      title: 'Aventura',
      img: 'img/portada-1.jpg',
      cantidad: 20,
    },
    {
      title: 'Ciencia Ficción',
      img: 'img/portada-3.jpg',
      cantidad: 10,
    } 
  ]
}
