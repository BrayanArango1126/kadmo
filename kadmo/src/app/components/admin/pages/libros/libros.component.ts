import { Component } from '@angular/core';
import { LibrosService } from '../../../../services/libros.service';
import Libros from '../../../../interfaces/libros';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LibrosPublicadosService } from '../../../../services/libros-publicados.service';
import LibroPublicado from '../../../../interfaces/libroPublicado';
import { EstadosLibrosService } from '../../../../services/estados-libros.service';
import { DisponibilidadLibrosService } from '../../../../services/disponibilidad-libros.service';
import { CategoriasLibrosService } from '../../../../services/categorias-libros.service';
import EstadoLibro from '../../../../interfaces/estadoLibro';
import CategoriaLibro from '../../../../interfaces/categoriaLibro';
import DisponibilidadLibro from '../../../../interfaces/disponibilidadLibro';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrl: './libros.component.css'
})
export class LibrosComponent {


  idUser = localStorage.getItem('user') || '0';
  formLibro!:FormGroup;
  booksList:Libros[] = [];

  librosFiltrados:Libros[] = [];
  librosPublicados:LibroPublicado[] = [];
  estadosLibros:EstadoLibro[] = [];
  categories:CategoriaLibro[] = [];
  disponibilidadLibros:DisponibilidadLibro[] = [];
  selectedCategories:CategoriaLibro[] = [];


  constructor(
    private _librosService:LibrosService, 
    private _librosPublicadosService:LibrosPublicadosService, 
    private fb:FormBuilder,
    private _estadosLibrosService:EstadosLibrosService,
    private _disponibilidadLibrosService:DisponibilidadLibrosService,
    private _categoriasService:CategoriasLibrosService
  ) {
    this.formLibro = this.fb.group({
      idLibros: [''],
      nombre: ['', Validators.required],
      autor: ['', Validators.required],
      precio: ['', Validators.required],
      descripcion: ['', Validators.required],
      estadosLibro: ['', Validators.required],
      categoriasLibro: ['', Validators.required]
    });
   }

  ngOnInit(): void {
    this.getBooks();
    this.getDisponibilidadLibros();
    this.getCategories();
    this.getEstadosLibros();
  }

  public getBooks(){
    this._librosService.getLibros().subscribe({
      next: (data) => {
        this.booksList = data;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public cleandForm(){
    this.formLibro.reset();
  }

  public addNewBook(){
    const libro:Libros = {
      idLibros: 0,
      nombre: this.formLibro.get('nombre')?.value,
      autor: this.formLibro.get('autor')?.value,
      precio: this.formLibro.get('precio')?.value,
      descripcion: this.formLibro.get('descripcion')?.value,
      estadosLibro: {
        idEstadosLibros: this.formLibro.get('estadosLibro')?.value,
        estado: ''
      },
      disponibilidadLibro: {
        idDisponibilidadLibro: 1,
        disponibilidad: ''
      },
      categoriasLibro: {
        idCategoriaLibro: this.formLibro.get('categoriasLibro')?.value,
        categoria: ''
      }
    }
  }
  public sendBookModal(idLibro:number){
    const libro = this.booksList.find(libro => libro.idLibros === idLibro);
    console.log(libro);
    this.formLibro.setValue({
      idLibros: libro?.idLibros,
      nombre: libro?.nombre,
      autor: libro?.autor,
      precio: libro?.precio,
      descripcion: libro?.descripcion,
      estadosLibro: libro?.estadosLibro.idEstadosLibros,
      categoriasLibro: libro?.categoriasLibro.idCategoriaLibro
    });
  }

  public updateBook(){
    const libro:Libros = {
      idLibros: this.formLibro.get('idLibros')?.value,
      nombre: this.formLibro.get('nombre')?.value,
      autor: this.formLibro.get('autor')?.value,
      precio: this.formLibro.get('precio')?.value,
      descripcion: this.formLibro.get('descripcion')?.value,
      estadosLibro: {
        idEstadosLibros: this.formLibro.get('estadosLibro')?.value,
        estado: ''
      },
      disponibilidadLibro: {
        idDisponibilidadLibro: 1,
        disponibilidad: ''
      },
      categoriasLibro: {
        idCategoriaLibro: this.formLibro.get('categoriasLibro')?.value,
        categoria: ''
      }
    }
    this._librosService.updateLibro(libro).subscribe({
      next: (res) => {
        alert(res.message);
        this.getBooks();
      },
      error: (err) => {
        console.log(err);
      },
      complete: () => {
        this.formLibro.reset();
      }
    });
  }

  public publicarLibro(){
    if(this.formLibro.invalid){
      alert('Debes llenar todos los campos');
      return;
    }

    const libro:Libros = {
      idLibros: 0,
      nombre: this.formLibro.get('nombre')?.value,
      autor: this.formLibro.get('autor')?.value,
      precio: this.formLibro.get('precio')?.value,
      descripcion: this.formLibro.get('descripcion')?.value,
      estadosLibro: {
        idEstadosLibros: this.formLibro.get('estadosLibro')?.value,
        estado: ''
      },
      disponibilidadLibro: {
        idDisponibilidadLibro: 1,
        disponibilidad: ''
      },
      categoriasLibro: {
        idCategoriaLibro: this.formLibro.get('categoriasLibro')?.value,
        categoria: ''
      }
    }

    this._librosService.addLibro(libro).subscribe({
      next: (res) => {
        console.log(res.datos);
        this.postLibroPublicado(res.datos.idLibros);
        this.getBooks();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public postLibroPublicado(idLibro:number){
    const libroPublicado:LibroPublicado = {
      idLibrosPublicados: 0,
      libro: {
        idLibros: idLibro,
        nombre: '',
        autor: '',
        precio: 0,
        descripcion: '',
        estadosLibro: {
          idEstadosLibros: 0,
          estado: ''
        },
        disponibilidadLibro: {
          idDisponibilidadLibro: 0,
          disponibilidad: ''
        },
        categoriasLibro: {
          idCategoriaLibro: 0,
          categoria: ''
        }
      },
      usuario: {
        idUsuario: parseInt(this.idUser) || 0,
        correo: '',
        contraseña: '',
        rol: {
          idRol: 0,
          rol: ''
        }
      }
    }

    this._librosPublicadosService.addLibroPublicado(libroPublicado).subscribe({
      next: (res) => {
        // console.log(res);
        alert(res.message);
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public getDisponibilidadLibros(){
    this._disponibilidadLibrosService.getDisponibilidadLibros().subscribe({
      next: (res) => {
        // console.log(res);
        this.disponibilidadLibros = res;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public getCategories(){
    this._categoriasService.getCategoriasLibros().subscribe({
      next: (res) => {
        // console.log(res);
        this.categories = res;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public getEstadosLibros(){
    this._estadosLibrosService.getEstadosLibros().subscribe({
      next: (res) => {
        //console.log(res);
        this.estadosLibros = res;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

}
