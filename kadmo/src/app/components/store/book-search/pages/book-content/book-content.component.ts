import { Component, Input } from '@angular/core';
import Libros from '../../../../../interfaces/libros';

@Component({
  selector: 'app-book-content',
  templateUrl: './book-content.component.html',
  styleUrl: './book-content.component.css',
  standalone: false
})
export class BookContentComponent {

  @Input() book!: Libros;

}
