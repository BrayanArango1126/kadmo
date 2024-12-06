import { Component, OnInit } from '@angular/core';
import DatosUsuario from '../../../../interfaces/datosUsuario';
import { DatoUsuarioService } from '../../../../services/dato-usuario.service';
import { UsuarioService } from '../../../../services/usuario.service';
import Usuario from '../../../../interfaces/usuario';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RolesService } from '../../../../services/roles.service';
import Rol from '../../../../interfaces/rol';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  users: Usuario[] = [];
  listAllRoles:Rol[] = [];

  formUser!: FormGroup;
  constructor(private _usuarioSerive: UsuarioService, private _rolesService:RolesService, private fb:FormBuilder) {
    this.formUser = this.fb.group({
      idUsuario: [''],
      email: ['', Validators.required],
      password: ['', Validators.required],
      idRol: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.getUsers();
    this.getRoles();
  }

  public cleandForm(){
    this.formUser.reset();
  }

  public getRoles(){
    this._rolesService.getRoles().subscribe({
      next: (res) => {
        this.listAllRoles = res;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public getUsers(){
    this._usuarioSerive.getAllUsuarios().subscribe({
      next: (res) => {
        this.users = res;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public addUsuario(){
    const usuario: Usuario = {
      idUsuario: 0,
      correo: this.formUser.get('email')?.value,
      contraseña: this.formUser.get('password')?.value,
      rol: {
        idRol: this.formUser.get('idRol')?.value
      } 
    }
    this._usuarioSerive.Registrarse(usuario).subscribe({
      next: (res) => {
        alert(res.message);
        this.getUsers();
        this.cleandForm();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public setDatosUser(usuarioId: number){
    let usuario = this.users.find((user) => user.idUsuario === usuarioId);
    this.formUser.setValue({
      idUsuario: usuario?.idUsuario,
      email: usuario?.correo,
      password: usuario?.contraseña,
      idRol: usuario?.rol.idRol
    });
  }

  public updateUsuario(){
    const usuario: Usuario = {
      idUsuario: this.formUser.get('idUsuario')?.value,
      correo: this.formUser.get('email')?.value,
      contraseña: this.formUser.get('password')?.value,
      rol: {
        idRol: this.formUser.get('idRol')?.value
      }
    }
    this._usuarioSerive.updateUsuario(usuario).subscribe({
      next: (res) => {
        alert(res.message);
        this.getUsers();
        this.cleandForm();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
}
