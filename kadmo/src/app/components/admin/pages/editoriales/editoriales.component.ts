import { Component, OnInit } from '@angular/core';
import Editorial from '../../../../interfaces/editoriales';
import { EditorialesService } from '../../../../services/editoriales.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-editoriales',
  templateUrl: './editoriales.component.html',
  styleUrls: ['./editoriales.component.css']
})
export class EditorialesComponent implements OnInit {

  editorial: Editorial[] = [];
  formEditorial!: FormGroup;


  constructor(private editorialService: EditorialesService, private fb:FormBuilder) {
    this.formEditorial = this.fb.group({
      idEditoriales: ['', Validators.required],
      direccion: ['', Validators.required ],
      nombre: ['', Validators.required],
      telefono: ['', Validators.required],
      usuario: {
        idUsuario: ['', Validators.required],
        correo: ['', Validators.required],
        contraseña: ['', Validators.required],
        rol: {
          idRol: ['', Validators.required]
        }
      }
    });
   }

  ngOnInit(): void {
    this.getEditoriales();
  }

  public cleandForm(){
    this.formEditorial.reset();
  }

  public getEditoriales(){
    this.editorialService.getAllEditoriales().subscribe({
      next: (res) => {
        this.editorial = res;
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  public addEditorial(){
    this.editorialService.addEditorial(this.editorial[0]).subscribe({
      next: (res) => {
        console.log(res);
        this.getEditoriales();
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

}
