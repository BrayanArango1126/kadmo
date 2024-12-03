import { Component } from '@angular/core';
import { CategoriasLibrosService } from '../../../../../services/categorias-libros.service';
import CategoriaLibro from '../../../../../interfaces/categoriaLibro';
import { LibrosService } from '../../../../../services/libros.service';
import { LibrosPublicadosService } from '../../../../../services/libros-publicados.service';
import { FormGroup, FormBuilder, Validators, FormArray, FormControl } from '@angular/forms';
import { EstadosLibrosService } from '../../../../../services/estados-libros.service';
import EstadoLibro from '../../../../../interfaces/estadoLibro';
import Libros from '../../../../../interfaces/libros';
import LibroPublicado from '../../../../../interfaces/libroPublicado';
import DisponibilidadLibro from '../../../../../interfaces/disponibilidadLibro';
import { DisponibilidadLibrosService } from '../../../../../services/disponibilidad-libros.service';
import FiltroLibros from '../../../../../interfaces/filtroLibrosDTO';
import { LibrosSharedFiltersService } from '../../../../../services/libros-shared-filters.service';

@Component({
  selector: 'app-aside-books-section',
  templateUrl: './aside-books-section.component.html',
  styleUrl: './aside-books-section.component.css'
})
export class AsideBooksSectionComponent {

  idUser = localStorage.getItem('user') || '0';
  rangeValue:number = 0;
  maxStars = 5;
  selectedStars = 0;
  formLibro:FormGroup;
  formFilter:FormGroup;

  librosFiltrados:Libros[] = [];
  librosPublicados:LibroPublicado[] = [];
  estadosLibros:EstadoLibro[] = [];
  categories:CategoriaLibro[] = [];
  disponibilidadLibros:DisponibilidadLibro[] = [];
  selectedCategories:CategoriaLibro[] = [];

  constructor(
    private _categoriasService:CategoriasLibrosService,
    private _librosService:LibrosService,
    private _librosPublicadosService:LibrosPublicadosService,
    private _estadosLibrosService:EstadosLibrosService,
    private _disponibilidadLibrosService:DisponibilidadLibrosService,
    private _librosSharedFiltersService:LibrosSharedFiltersService,
    private fb:FormBuilder,
    private fbFilter:FormBuilder
  ) { 
    this.formLibro = this.fb.group({
      nombre: ['', Validators.required],
      autor: ['', Validators.required],
      precio: ['', Validators.required],
      descripcion: ['', Validators.required],
      estadosLibro: ['', Validators.required],
      categoriasLibro: ['', Validators.required]
    });

    this.formFilter = this.fbFilter.group({
      autor: [''],
      disponibilidad: [''],
      categoriasLibro: [''],
      estadosLibro: [''],
      precioLibro: ['']
    });
  }

  ngOnInit(): void {
    this.getLibrosPublicados();
    this.getCategories();
    this.getEstadosLibros();
    this.getDisponibilidadLibros();
  }

  public getLibrosPublicados(){
    this._librosPublicadosService.getLibrosPublicados().subscribe({
      next: (res) => {
        // console.log(res);
        this.librosPublicados = res;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public filtrarLibros(){
    const request:FiltroLibros = {}

    if(this.formFilter.get('autor')?.value){
      request.autor = this.formFilter.get('autor')?.value;
    }
    if(this.formFilter.get('disponibilidad')?.value){
      request.disponibilidadLibro = {
        idDisponibilidadLibro: this.formFilter.get('disponibilidad')?.value,
        disponibilidad: ''
      }
    }
    if(this.formFilter.get('estadosLibro')?.value){
      request.estadosLibro = {
        idEstadosLibros: this.formFilter.get('estadosLibro')?.value,
        estado: ''
      }
    }
    if(this.formFilter.get('precioLibro')?.value){
      request.precio = this.formFilter.get('precioLibro')?.value;
    }
    if(this.selectedCategories.length > 0){
      request.categoriasLibro = this.selectedCategories;
    }

    this._librosService.filterLibros(request).subscribe({
      next: (res) => {
        if(res.length > 0){
          this._librosSharedFiltersService.actualizarLibros(res);
        }else{
          alert('No se encontraron libros con los filtros seleccionados');
        }
        console.log(res);
        // console.log(res);
        // this.librosFiltrados = res;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public onCheckboxChange(event: any, category: any) {
    if (event.target.checked) {
      // Si el checkbox se selecciona, lo agregamos a la lista
      this.selectedCategories.push(category);
    } else {
      // Si se deselecciona, lo eliminamos de la lista
      this.selectedCategories = this.selectedCategories.filter(
        item => item.idCategoriaLibro !== category.idCategoriaLibro
      );
    }
    // console.log(this.selectedCategories); // Ver la lista actualizada
  }
  
  
  public validarSesion(){
    if(this.idUser == null || this.idUser == '0'){
      alert('Debes iniciar sesión para publicar un libro');
      return;
    }
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

  public onStarClick(starId: number) {
    this.selectedStars = starId;
  }

  public getRange(count: number) {
    return Array(count);
  }

  public publicarLibro(){
    if(this.idUser == null || this.idUser == '0'){
      alert('Debes iniciar sesión para publicar un libro');
      return;
    }
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


}
