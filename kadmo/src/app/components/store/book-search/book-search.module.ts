import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookSearchRoutingModule } from './book-search-routing.module';
import { BookContentComponent } from './pages/book-content/book-content.component';
import { BookNotesComponent } from './pages/book-notes/book-notes.component';
import { BookDescriptionComponent } from './pages/book-description/book-description.component';

@NgModule({
  declarations: [
    BookContentComponent,
    BookDescriptionComponent,
    BookNotesComponent
  ],
  imports: [
    CommonModule,
    BookSearchRoutingModule,
    
  ],
  exports: [
    BookContentComponent,
    BookDescriptionComponent,
    BookNotesComponent
  ]
})
export class BookSearchModule { }
