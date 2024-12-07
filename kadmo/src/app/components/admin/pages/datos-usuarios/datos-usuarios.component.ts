import { Component } from '@angular/core';
import DatosUsuario from '../../../../interfaces/datosUsuario';
import { DatoUsuarioService } from '../../../../services/dato-usuario.service';

@Component({
  selector: 'app-datos-usuarios',
  templateUrl: './datos-usuarios.component.html',
  styleUrl: './datos-usuarios.component.css'
})
export class DatosUsuariosComponent {

  //Paginación
  items: any[] = []; // Lista completa de elementos
  currentPage: number = 1; // Página actual
  itemsPerPage: number = 7; // Elementos por página
  totalItems: number = 0; // Total de elementos

  
  usersDatos: DatosUsuario[] = [];

  constructor(private datoUserService: DatoUsuarioService) {}

  ngOnInit(): void {
    this.getUsersData();
  }

  onPageChange(page: number): void {
    this.currentPage = page; // Cambia la página actual
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
