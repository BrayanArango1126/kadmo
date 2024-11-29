import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { VentasComponent } from './pages/ventas/ventas.component';
import { AsideNavComponent } from './pages/aside-nav/aside-nav.component';
import { ReportesComponent } from './pages/reportes/reportes.component';
import { LibrosComponent } from './pages/libros/libros.component';
import { CalificacionesComponent } from './pages/calificaciones/calificaciones.component';
import { CategoriasComponent } from './pages/categorias/categorias.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { EditorialesComponent } from './pages/editoriales/editoriales.component';


@NgModule({
  declarations: [
    AdminComponent,
    DashboardComponent,
    VentasComponent,
    AsideNavComponent,
    ReportesComponent,
    LibrosComponent,
    CalificacionesComponent,
    CategoriasComponent,
    UsuariosComponent,
    EditorialesComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
  ]
})
export class AdminModule { }
