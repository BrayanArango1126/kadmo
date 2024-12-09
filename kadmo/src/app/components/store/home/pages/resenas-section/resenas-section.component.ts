import { Component } from '@angular/core';
import { CalificacionService } from '../../../../../services/calificacion.service';
import CalificacionLibro from '../../../../../interfaces/calificacionLibro';
import { DatoUsuarioService } from '../../../../../services/dato-usuario.service';
import DatosUsuario from '../../../../../interfaces/datosUsuario';

@Component({
  selector: 'app-resenas-section',
  templateUrl: './resenas-section.component.html',
  styleUrl: './resenas-section.component.css'
})
export class ResenasSectionComponent {
  calificaciones:CalificacionLibro[] = [];
  datoUsuario:DatosUsuario[] =[];

  constructor(
    private _calificacionesService:CalificacionService,
    private _datosUsuariosService:DatoUsuarioService
  ) { }

  ngOnInit(): void {
    this.getCalificaciones();
  }

  public getCalificaciones(){
    this._calificacionesService.getAllCalificaciones().subscribe({
      next: (res) => {
        this.calificaciones = res;
        this.getDatosUsuariosById();
        console.log(res);
      },
      error: err => {
        console.log(err);
      }
    });
  }

  public getDatosUsuariosById(){  
    this.calificaciones.forEach(review => {
        this._datosUsuariosService.getDatoUsuarioById(review.usuario).subscribe({
          next: (data) => {
            console.log(data);
            this.datoUsuario.push(data);
          },
          error: (err) => {
            console.log(err);
          }
      });
      });
  }
}
