import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RolesService } from '../../../services/roles.service';
import Rol from '../../../interfaces/rol';
import { UsuarioService } from '../../../services/usuario.service';
import Usuario from '../../../interfaces/usuario';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  listAllRoles: Rol[] = [];
  registerForm!: FormGroup;

  constructor(private fb: FormBuilder, private _rolService: RolesService, private _usuarioService: UsuarioService) {
    this.buildForm();
  }

  ngOnInit(): void {
    this.getAllRoles();
  }

  private buildForm(){
    const mailRgx = /^[^\s@]+@+(hotmail|gmail|outlook)\.(com|co|edu\.co)/;
    const pswRgx = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,15}/;

    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.pattern(mailRgx), Validators.minLength(10), Validators.maxLength(50)]],
      password: ['', [Validators.required, Validators.pattern(pswRgx), Validators.minLength(8), Validators.maxLength(15)]],
      rol: ['', [Validators.required]],
    });
  }

  public getAllRoles(){
    this._rolService.getRoles().subscribe({
      next: roles => {
        this.listAllRoles = roles;
      },
      error: err => {
        console.log(err);
      }
    });
  }

  public register(){
    const newUser:Usuario = {
      idUsuario: 0,
      correo: this.registerForm.get('email')?.value,
      contraseña: this.registerForm.get('password')?.value,
      rol: {
        idRol: this.registerForm.get('rol')?.value
      }
    }
    console.log(newUser);
    this._usuarioService.Registrarse(newUser).subscribe({
      next: res => {
        alert(res.message);
        window.location.href = '/login';
      },
      error: err => {
        console.log(err);
      }
    });
  }

  onSubmit() {
    console.log(this.registerForm.value);
  }
}
