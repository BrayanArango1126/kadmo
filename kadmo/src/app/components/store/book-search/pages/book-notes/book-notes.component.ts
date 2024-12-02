import { Component, Input } from '@angular/core';
import calificacionesByLibroId from '../../../../../interfaces/calificacionesByLibroId';
import Libros from '../../../../../interfaces/libros';
import DatosUsuario from '../../../../../interfaces/datosUsuario';
import CalificacionLibro from '../../../../../interfaces/calificacionLibro';

@Component({
  selector: 'app-book-notes',
  templateUrl: './book-notes.component.html',
  styleUrl: './book-notes.component.css',
  standalone: false
})
export class BookNotesComponent {
  format= 'dd/MM/yyyy';

  book:Libros = {
    idLibros: 0,
    nombre: "",
    autor: "",
    precio: 0,
    descripcion: "",  
    estadosLibro: {
      idEstadosLibros: 0,
      estado: "",
    },
    disponibilidadLibro: {
      idDisponibilidadLibro: 0,
      disponibilidad: "",
    },
    categoriasLibro: {
      idCategoriaLibro: 0,
      categoria: "",
    }
  }

  datoUsuario:DatosUsuario = {
    idDatoUsuario: 0,
    nombres: "",
    apellidos: "",
    direccion: "",
    documento: "",
    telefono: "",
    edad: 0,
    usuarioVerificado: 0,
    genero: {
      idGenero: 0,
    },
    usuario: {
      idUsuario: 0,
    }
  };

  noteList:CalificacionLibro[] = [];

  notes:any = [
    {
      autor: 'Jorge Luis Borges',
      note: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor repellendus sunt porro voluptas mollitia? Eius ad ea maiores ratione ducimus, fugiat, saepe quisquam similique magnam perspiciatis laudantium reprehenderit laboriosam recusandae! Tempora, adipisci? Asperiores tenetur dolorem, repudiandae laborum voluptates iure neque cupiditate, perferendis error mollitia ratione ab accusantium magni, excepturi quisquam dolor. Mollitia minus est neque tempore non velit numquam corporis!.',
      img: 'img/user.jpg',
      publishedAt: '2021-09-01'
    },
    {
      autor: 'Alisa Grill',
      note: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor repellendus sunt porro voluptas mollitia? Eius ad ea maiores ratione ducimus, fugiat, saepe quisquam similique magnam perspiciatis laudantium reprehenderit laboriosam recusandae! Tempora, adipisci? Asperiores tenetur dolorem, repudiandae laborum voluptates iure neque cupiditate, perferendis error mollitia ratione ab accusantium magni, excepturi quisquam dolor. Mollitia minus est neque tempore non velit numquam corporis!.',
      img: 'img/user.jpg',
      publishedAt: '2021-09-01'
    },
    {
      autor: 'Jorge Luis Borges',
      note: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor repellendus sunt porro voluptas mollitia? Eius ad ea maiores ratione ducimus, fugiat, saepe quisquam similique magnam perspiciatis laudantium reprehenderit laboriosam recusandae! Tempora, adipisci? Asperiores tenetur dolorem, repudiandae laborum voluptates iure neque cupiditate, perferendis error mollitia ratione ab accusantium magni, excepturi quisquam dolor. Mollitia minus est neque tempore non velit numquam corporis!.',
      img: 'img/user.jpg',
      publishedAt: '2021-09-01'
    },
    {
      autor: 'Emma Gonzalez',
      note: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Dolor repellendus sunt porro voluptas mollitia? Eius ad ea maiores ratione ducimus, fugiat, saepe quisquam similique magnam perspiciatis laudantium reprehenderit laboriosam recusandae! Tempora, adipisci? Asperiores tenetur dolorem, repudiandae laborum voluptates iure neque cupiditate, perferendis error mollitia ratione ab accusantium magni, excepturi quisquam dolor. Mollitia minus est neque tempore non velit numquam corporis!.',
      img: 'img/user.jpg',
      publishedAt: '2021-09-01'
    }
  ]
}
