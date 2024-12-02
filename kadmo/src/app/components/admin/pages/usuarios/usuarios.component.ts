import { Component, OnInit } from '@angular/core';
import DatosUsuario from '../../../../interfaces/datosUsuario';
import { DatoUsuarioService } from '../../../../services/dato-usuario.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  users: DatosUsuario[] = [];

  constructor(private datoUserService: DatoUsuarioService) {}

  ngOnInit(): void {
    this.datoUserService.getAllDatoUsuarios().subscribe(data => {
      this.users = data;
    });
  }
}
