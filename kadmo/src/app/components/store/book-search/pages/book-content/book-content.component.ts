import { Component, Input, OnInit } from '@angular/core';
import Libros from '../../../../../interfaces/libros';
import ImagenesLibros from '../../../../../interfaces/imagenesLibros';
import { ImagenesLibrosService } from '../../../../../services/imagenes-libros.service';

@Component({
  selector: 'app-book-content',
  templateUrl: './book-content.component.html',
  styleUrl: './book-content.component.css',
  standalone: false,
})
export class BookContentComponent implements OnInit {
  @Input() book!: Libros;

  listAllImages: ImagenesLibros[] = [];

  imagenLibro!: ImagenesLibros;

  constructor(private _imagenesLibrosService: ImagenesLibrosService) {}

  ngOnInit(): void {
    this.getAllImages();
  }

  getAllImages() {
    this._imagenesLibrosService.getImagenesLibros().subscribe({
      next: (data) => {
        this.listAllImages = data;
      },
      error: (error) => {
        console.error(error);
      },
    });
  }

  public getImageByIdLibro(idLibro: number) {
    let url = this.listAllImages.find(
      (imagen) => imagen.libro.idLibros == idLibro
    );
    if (url) {
      return 'http://localhost:8080' + url.url;
    }
    return 'assets/images/book-placeholder.png';
  }
}
