import { Component, OnInit } from '@angular/core';
import {FormGroup, Validators, FormBuilder, ReactiveFormsModule} from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { UsuarioService } from '../../services/usuario.service';
import Usuario from '../../interfaces/usuario';
import DatosUsuario from '../../interfaces/datosUsuario';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{

  idUsuario: number = 0;
  registerForm :FormGroup;

  constructor( private fb:FormBuilder) {
    this.registerForm = this.fb.group({
      correo: ['', Validators.required],
      contraseña: ['', Validators.required],
      idRol: [0, Validators.required],
      nombres: ['', Validators.required ],
      apellidos: ['', Validators.required ],
      direccion: ['', Validators.required ],
      documento: ['', Validators.required ],
      telefono: ['', Validators.required ],
      edad: ['', Validators.required ],
      idGenero: ['', Validators.required ],
    });
   }

  ngOnInit(): void {
      
  }

  async registrarse(){
    const request: Usuario = {
      correo: this.registerForm.value.correo,
      contraseña: this.registerForm.value.contraseña,
      role: {
        idRol: this.registerForm.value.idRol
      }
    }

    try{
      // console.log(request);
      const respuesta = await UsuarioService.registrarUsuario(request)
      if(respuesta.status == 200){
        let listaUsuarios = respuesta.data;
        let posicionUsuario = listaUsuarios.length - 1;
        this.idUsuario = respuesta.data[posicionUsuario].idUsuario;
        console.log(this.idUsuario);

      }else{
        console.log("Hubo un problema al registrar el usuario");
        console.log(respuesta.data);
        this.idUsuario = 0;
      }
    }catch(error){
      console.log(error);
    }

    if(this.idUsuario !== 0){
      const requestDatosUsuario :DatosUsuario = {
        nombres: this.registerForm.value.nombres,
        apellidos: this.registerForm.value.apellidos,
        direccion: this.registerForm.value.direccion,
        documento: this.registerForm.value.documento,
        telefono: this.registerForm.value.telefono,
        edad: this.registerForm.value.edad,
        genero: {
          idGenero: this.registerForm.value.idGenero
        },
        usuarioVerificado: 0,
        usuario: {
          idUsuario: this.idUsuario
        }
      }

      try{
        // console.log(requestDatosUsuario);
        const respuestaDatosUsuario = await UsuarioService.registrarDatosUsuarios(requestDatosUsuario);
        if(respuestaDatosUsuario.status == 200){
          console.log("Datos de usuario registrados correctamente");
          console.log(respuestaDatosUsuario.data);
        }else{
          console.log("Hubo un problema al registrar los datos de usuario");
          console.log(respuestaDatosUsuario.data);
        }
      }catch(error){
        console.log(error);
      }
      
    }else{
      console.log("No se pudo registrar el usuario, por lo tanto no se registraron los datos del usuario");
    }

    
  }

  onSubmit(){
    this.registrarse();
  }
}
