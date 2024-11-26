import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StoreComponent } from './store.component';
import { AppRoutingModule } from '../../app-routing.module';
import { HomeComponent } from './home/home.component';
import { MainSectionComponent } from './home/pages/main-section/main-section.component';
import { BestSellerSectionComponent } from './home/pages/best-seller-section/best-seller-section.component';
import { CategoriesSectionComponent } from './home/pages/categories-section/categories-section.component';
import { ResenasSectionComponent } from './home/pages/resenas-section/resenas-section.component';


@NgModule({
  declarations: [
    StoreComponent,
    HomeComponent,
    MainSectionComponent,
    BestSellerSectionComponent,
    CategoriesSectionComponent,
    ResenasSectionComponent,
  ],
  imports: [
    CommonModule,
    AppRoutingModule
  ]
})
export class StoreModule { }
