import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookSearchRoutingModule } from './book-search-routing.module';
import { BookContentComponent } from './book-content/book-content.component';
import { BookDescriptionComponent } from './book-description/book-description.component';
import { BookNotesComponent } from './book-notes/book-notes.component';


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
