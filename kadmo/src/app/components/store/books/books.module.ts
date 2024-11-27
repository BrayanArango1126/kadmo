import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AsideBooksSectionComponent } from './pages/aside-books-section/aside-books-section.component';
import { MainBooksSectionComponent } from './pages/main-books-section/main-books-section.component';

@NgModule({
  declarations: [
    AsideBooksSectionComponent,
    MainBooksSectionComponent,
  ],
  imports: [
    CommonModule,
  ],
  exports:[
    AsideBooksSectionComponent,
    MainBooksSectionComponent

  ]
})
export class BooksModule { }
