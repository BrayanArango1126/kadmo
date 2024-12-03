import { Component, Input } from '@angular/core';
import calificacionesByLibroId from '../../../../../interfaces/calificacionesByLibroId';
import Libros from '../../../../../interfaces/libros';
import DatosUsuario from '../../../../../interfaces/datosUsuario';
import CalificacionLibro from '../../../../../interfaces/calificacionLibro';
import { DatoUsuarioService } from '../../../../../services/dato-usuario.service';
import Usuario from '../../../../../interfaces/usuario';

@Component({
  selector: 'app-book-notes',
  templateUrl: './book-notes.component.html',
  styleUrl: './book-notes.component.css',
  standalone: false
})
export class BookNotesComponent {
  @Input() reviewsList:CalificacionLibro[] = [];

  format= 'dd/MM/yyyy';

  datoUsuario:DatosUsuario[] = [];

  constructor(private _datosUsuariosService:DatoUsuarioService) { }

  ngOnInit():void {
   
  }

  ngOnChanges():void {
    this.getDatosUsuariosById();
  }

  public getDatosUsuariosById(){  
    this.reviewsList.forEach((review) => {
      this._datosUsuariosService.getDatoUsuarioById(review.usuario).subscribe({
        next: (data) => {
          this.datoUsuario.push(data);
        },
        error: (err) => {
          console.log(err);
        }
      });
    });
  }
}
