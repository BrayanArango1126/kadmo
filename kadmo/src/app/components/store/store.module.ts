import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StoreComponent } from './store.component';
import { MainSectionComponent } from './home/pages/main-section/main-section.component';
import { BestSellerSectionComponent } from './home/pages/best-seller-section/best-seller-section.component';
import { CategoriesSectionComponent } from './home/pages/categories-section/categories-section.component';
import { ResenasSectionComponent } from './home/pages/resenas-section/resenas-section.component';
import { BooksComponent } from './books/books.component';
import { HomeComponent } from './home/home.component';
import { StoreRoutingModule } from './store-routing.module';
import { BooksModule } from './books/books.module';
import { BookSearchComponent } from './book-search/book-search.component';
import { BookDescriptionComponent } from './book-search/book-description/book-description.component';
import { BookContentComponent } from './book-search/book-content/book-content.component';
import { BookNotesComponent } from './book-search/book-notes/book-notes.component';


@NgModule({
  declarations: [
    StoreComponent,
    HomeComponent,
    MainSectionComponent,
    BestSellerSectionComponent,
    CategoriesSectionComponent,
    ResenasSectionComponent,
    BooksComponent,
    BookSearchComponent,
    BookDescriptionComponent,
    BookContentComponent,
    BookNotesComponent
  ],
  imports: [
    CommonModule,
    StoreRoutingModule,
    BooksModule
  ]
})
export class StoreModule { }
