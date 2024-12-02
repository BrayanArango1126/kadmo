import { Component } from '@angular/core';
import { CalificacionService } from '../../../../../services/calificacion.service';
import CalificacionLibro from '../../../../../interfaces/calificacionLibro';
import { LibrosService } from '../../../../../services/libros.service';
import Libros from '../../../../../interfaces/libros';
import { DatoUsuarioService } from '../../../../../services/dato-usuario.service';
import DatosUsuario from '../../../../../interfaces/datosUsuario';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-book-notes',
  templateUrl: './book-notes.component.html',
  styleUrl: './book-notes.component.css'
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

  constructor(private _calificacionService:CalificacionService, private _librosService:LibrosService, private _datoUsuarioService:DatoUsuarioService, private _activatedRoute: ActivatedRoute) {} 
  
  async ngOnInit():Promise<void> {
    const idLibro = this._activatedRoute.snapshot.params['id'];
  if (idLibro) {
    this.getLibroById(idLibro); // Espera a cargar el libro
    this.getCalificaciones(idLibro); // Llama después de cargar el libro
    await this.getDatoUsuarioById(3)
  }
  }


  public getCalificaciones(libro:number){
    this._calificacionService.getCalificaciones({"idLibros": libro}).subscribe({
      next: (data) => {
        
        this.noteList = data;
        console.log(data);
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public getLibroById(id:number) {
    this._librosService.getLibroById(id).subscribe({
      next: (data) => {
      this.book = data;
      console.log(data);
    },
      error: (err) => {
        console.log(err)
      }
    });
  }
  public getDatoUsuarioById(idUsuario: number) {
    this._datoUsuarioService.getDatoUsuarioById({"idUsuario": idUsuario}).subscribe({
      next: (data) => {
        this.datoUsuario = data;
        console.log(data);
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
}
