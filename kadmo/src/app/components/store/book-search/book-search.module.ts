import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookSearchRoutingModule } from './book-search-routing.module';
import { BookNotesComponent } from './pages/book-notes/book-notes.component';
import { BookDescriptionComponent } from './pages/book-description/book-description.component';
import { BookCreateNoteComponent } from './pages/book-create-note/book-create-note.component';
import { LastViewsComponent } from './pages/last-views/last-views.component';
import { BookContentComponent } from './pages/book-content/book-content.component';

@NgModule({
  declarations: [
    BookDescriptionComponent,
    BookContentComponent,
    BookNotesComponent,
    BookCreateNoteComponent,
    LastViewsComponent
  ],
  imports: [
    CommonModule,
    BookSearchRoutingModule,
    
  ],
  exports: [
    BookDescriptionComponent,
    BookContentComponent,
    BookNotesComponent,
    BookCreateNoteComponent,
    LastViewsComponent
  ]
})

export class BookSearchModule { }
