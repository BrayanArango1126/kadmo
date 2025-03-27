import { Component, Input, OnInit } from '@angular/core';
import { ReactiveFormsModule, Validators } from '@angular/forms';
import { ClasificadorComentariosService } from '../../../../../services/clasificador-comentarios.service';
import Clasificacion from '../../../../../interfaces/clasificacion';
import { FormGroup, FormBuilder } from '@angular/forms';
import CalificacionLibro from '../../../../../interfaces/calificacionLibro';
import { CalificacionService } from '../../../../../services/calificacion.service';
import Libros from '../../../../../interfaces/libros';
import { Router } from '@angular/router';
import CryptoJS from 'crypto-js';
import { environment } from '../../../../../../environments/environment';

@Component({
  selector: 'app-book-create-note',
  templateUrl: './book-create-note.component.html',
  styleUrl: './book-create-note.component.css',
  standalone: false,
})
export class BookCreateNoteComponent implements OnInit {
  idUser = localStorage.getItem('user') || '0';
  @Input() book!: Libros;
  form!: FormGroup;
  calificacionLibro!: CalificacionLibro;
  clasificacion!: Clasificacion;
  respuestaClasificacion = '';
  listCalificaciones: CalificacionLibro[] = [];

  constructor(
    private _clasificacionService: ClasificadorComentariosService,
    private _calificacionService: CalificacionService,
    private fb: FormBuilder,
    private route: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      idLibro: [''],
      idUsuario: [''],
      fechaCalificacion: [''],
      comentario: ['', Validators.required],
      puntuacion: [''],
    });
    this.getAllCalificaciones();
    this.idUser =
      this.idUser != '0'
        ? CryptoJS.AES.decrypt(this.idUser, environment.cryptPassword).toString(
            CryptoJS.enc.Utf8
          )
        : '0';
  }

  onSubmit() {
    this.clasificarComentario();
  }

  clasificarComentario() {
    if (this.idUser == '0') {
      alert('Debe iniciar sesión para calificar el libro');
      this.route.navigate(['/login']);
    }

    this.calificacionLibro = {
      idCalificacion: 0,
      libro: {
        idLibros: this.book.idLibros,
        nombre: '',
        precio: 0,
        autor: '',
        categoriasLibro: {
          idCategoriaLibro: 0,
          categoria: '',
        },
        descripcion: '',
        disponibilidadLibro: {
          idDisponibilidadLibro: 0,
          disponibilidad: '',
        },
        estadosLibro: {
          idEstadosLibros: 0,
          estado: '',
        },
      },
      usuario: {
        idUsuario: parseInt(this.idUser || '0'),
        correo: '',
        contraseña: '',
        rol: {
          idRol: 0,
          rol: '',
        },
      },
      fechaCalificacion: new Date().toISOString(),
      comentario: this.form.value.comentario,
      puntuacion: '',
    };
    // this.calificacionLibro = this.form.value;
    // this.calificacionLibro.libro.idLibros = this.book.idLibros;
    // this.calificacionLibro.fechaCalificacion = new Date().toISOString();

    // this.calificacionLibro.usuario.idUsuario = parseInt(idUsuario || '0');

    // console.log(this.calificacionLibro);
    this.getClasification();
  }

  getClasification() {
    this.clasificacion = {
      comentario: this.form.value.comentario,
      respuesta: '',
    };
    this._clasificacionService.getClasificacion(this.clasificacion).subscribe({
      next: (resp) => {
        // this.clasificacion.respuesta = resp.message;
        this.respuestaClasificacion = resp.message;
        // this.getAllCalificaciones();
        this.saveCalificacion(this.respuestaClasificacion);
      },
      error: (err) => {
        alert('Error al clasificar el comentario');
      },
    });
  }

  saveCalificacion(stringPuntuacion: string) {
    this.calificacionLibro.puntuacion = stringPuntuacion;

    this._calificacionService
      .createCalificacion(this.calificacionLibro)
      .subscribe({
        next: (resp) => {
          this.getAllCalificaciones();
          alert('Calificación guardada correctamente');
        },
        error: (err) => {
          alert('Error al guardar la calificación');
        },
        complete: () => {
          this.form.reset();
        },
      });
  }

  getAllCalificaciones() {
    this._calificacionService.getAllCalificaciones().subscribe({
      next: (resp) => {
        this.listCalificaciones = resp;
      },
      error: (err) => {
        alert('Error al obtener las calificaciones');
      },
    });
  }
}
