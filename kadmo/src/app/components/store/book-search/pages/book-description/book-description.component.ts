import { Component, Input } from '@angular/core';
import Libros from '../../../../../interfaces/libros';

@Component({
  selector: 'app-book-description',
  templateUrl: './book-description.component.html',
  styleUrl: './book-description.component.css',
  standalone: false

})
export class BookDescriptionComponent {

  @Input() libroProp:Libros[] = [];

}
