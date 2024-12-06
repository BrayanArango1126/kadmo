import { Component } from '@angular/core';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrl: './user-info.component.css'
})
export class UserInfoComponent {
  user = {
    name: 'Juan Pérez',
    email: 'juan.perez@example.com',
    phone: '+123 456 789',
    address: 'Calle Falsa 123, Ciudad Ejemplo',
    role: 'Administrador',
    memberSince: new Date('2020-01-01')
  };

  constructor() {}

  ngOnInit(): void {}

  editProfile(): void {
    alert('Función para editar perfil (implementa lógica aquí)');
  }

  logout(): void {
    alert('Función para cerrar sesión (implementa lógica aquí)');
    // Aquí podrías redirigir al usuario a la página de login
  }
}
