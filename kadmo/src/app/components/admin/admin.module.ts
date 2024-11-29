import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { GenerosComponent } from './pages/generos/generos.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { VentasComponent } from './pages/ventas/ventas.component';
import { AsideNavComponent } from './pages/aside-nav/aside-nav.component';


@NgModule({
  declarations: [
    AdminComponent,
    GenerosComponent,
    DashboardComponent,
    VentasComponent,
    AsideNavComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
