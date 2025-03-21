import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AsideBooksSectionComponent } from './pages/aside-books-section/aside-books-section.component';
import { MainBooksSectionComponent } from './pages/main-books-section/main-books-section.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    AsideBooksSectionComponent,
    MainBooksSectionComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ],
  exports:[
    AsideBooksSectionComponent,
    MainBooksSectionComponent,    
  ]
})
export class BooksModule { }
