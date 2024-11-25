import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardHomeComponent } from './pages/dashboard-home/dashboard-home.component';
import { AppRoutingModule } from '../../app-routing.module';
import { MainSectionComponent } from './pages/main-section/main-section.component';



@NgModule({
  declarations: [
    DashboardHomeComponent,
    MainSectionComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
  ],
  exports: [
    DashboardHomeComponent
  ]
})
export class HomeModule { }
