import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RolesService } from '../../../services/roles.service';
import Rol from '../../../interfaces/rol';
import { UsuarioService } from '../../../services/usuario.service';
import Usuario from '../../../interfaces/usuario';
import { infoAlert, redirectAlert } from '../../../../assets/alerts';
import { AuthGoogleService } from '../../../services/auth-google.service';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { getAuth } from '@angular/fire/auth';
import Cookies from 'js-cookie';
import { environment } from '../../../../environments/environment';
import * as cryptoJS from 'crypto-js';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  listAllRoles: Rol[] = [];
  registerForm!: FormGroup;

  constructor(
    private fb: FormBuilder, 
    private _rolService: RolesService, 
    private _usuarioService: UsuarioService,
    private _authGoogleService: AuthGoogleService,
    private _router: Router
  ) {
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
    // console.log(newUser);
    this._usuarioService.Registrarse(newUser).subscribe({
      next: res => {
        redirectAlert("success", "Registro exitoso", "login");
      },
      error: err => {
        infoAlert("error", "Error", "Los datos ingresados no son válidos.");
        console.log(err);
      }
    });
  }

  public async authGoogle(){
    try {
      
      const register = await this._authGoogleService.loginGoogle();

      if(register){
        this._authGoogleService.authState$().subscribe((data) => {
          if (data) {
            const newUser:Usuario = {
              idUsuario: 0,
              correo: data.email,
              contraseña: '',
              rol: {
                idRol: 4
              }
            }
          this._usuarioService.Registrarse(newUser).subscribe({
            next: res => {
              console.log(res.datos.idUsuario);
              localStorage.setItem('rol', cryptoJS.AES.encrypt(res.datos.rol.idRol.toString(), environment.cryptPassword).toString());
              localStorage.setItem('user', cryptoJS.AES.encrypt(res.datos.idUsuario.toString(), environment.cryptPassword).toString());
              // this.saveTokenGoogle(data.accessToken);
              redirectAlert("success", "Registro exitoso", "store");
            },
            error: err => {
              infoAlert("error", "Error", "Los datos ingresados no son válidos.");
              console.log(err);
            }
          });
          console.log('Usuario autenticado:', data);
            
          } else {
            console.log('No hay usuario autenticado');
          }
        });
        
      }

    } catch (error) {
      // infoAlert("error", "Error", "El proceso no se ha completado exitosamente.");
      console.log(error)
    }
  }

  // public saveTokenGoogle(token:string){
  //   return Cookies.set('authToken', cryptoJS.AES.encrypt(token.toString(), environment.cryptPassword).toString());
  // }

  // }
  // onSubmit() {
  //   console.log(this.registerForm.value);
  // }
}
