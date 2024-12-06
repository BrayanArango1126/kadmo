import { Component } from '@angular/core';
import DatosUsuario from '../../../../interfaces/datosUsuario';
import { DatoUsuarioService } from '../../../../services/dato-usuario.service';

@Component({
  selector: 'app-datos-usuarios',
  templateUrl: './datos-usuarios.component.html',
  styleUrl: './datos-usuarios.component.css'
})
export class DatosUsuariosComponent {
  usersDatos: DatosUsuario[] = [];

  constructor(private datoUserService: DatoUsuarioService) {}

  ngOnInit(): void {
    this.getUsersData();
  }

  public cleandForm(){
    
  }
  public getUsersData(){
    this.datoUserService.getAllDatoUsuarios().subscribe({
      next: (res) => {
        this.usersDatos = res;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
}
