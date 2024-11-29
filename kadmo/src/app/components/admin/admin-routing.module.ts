import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AdminComponent } from './admin.component';
import { VentasComponent } from './pages/ventas/ventas.component';
import { ReportesComponent } from './pages/reportes/reportes.component';
import { LibrosComponent } from './pages/libros/libros.component';
import { CalificacionesComponent } from './pages/calificaciones/calificaciones.component';
import { CategoriasComponent } from './pages/categorias/categorias.component';
import { UsuariosComponent } from './pages/usuarios/usuarios.component';
import { EditorialesComponent } from './pages/editoriales/editoriales.component';

// const routes: Routes = [
//   {path:'', component: AdminComponent},
//   {path:'dashboard', component: DashboardComponent},
//   {path:'ventas', component: VentasComponent},
//   {path:'aside', component: AsideNavComponent}
// ];

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'ventas', component: VentasComponent },
      { path: 'reportes', component: ReportesComponent },
      { path: 'libros', component: LibrosComponent },
      { path: 'calificaciones', component: CalificacionesComponent },
      { path: 'categorias', component: CategoriasComponent },
      { path: 'usuarios', component: UsuariosComponent },
      { path: 'editoriales', component: EditorialesComponent },
      // Add other routes here
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
