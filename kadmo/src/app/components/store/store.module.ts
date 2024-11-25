import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StoreComponent } from './store.component';
import { AppRoutingModule } from '../../app-routing.module';
import { HomeComponent } from './home/home.component';
import { MainSectionComponent } from './home/pages/main-section/main-section.component';


@NgModule({
  declarations: [
    StoreComponent,
    HomeComponent,
    MainSectionComponent,
  ],
  imports: [
    CommonModule,
    AppRoutingModule
  ]
})
export class StoreModule { }
