import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookSearchRoutingModule } from './book-search-routing.module';
import { BookContentComponent } from './pages/book-content/book-content.component';
import { BookNotesComponent } from './pages/book-notes/book-notes.component';
import { BookDescriptionComponent } from './pages/book-description/book-description.component';
import { BookCreateNoteComponent } from './pages/book-create-note/book-create-note.component';
import { LastViewsComponent } from './pages/last-views/last-views.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    BookContentComponent,
    BookDescriptionComponent,
    BookNotesComponent,
    BookCreateNoteComponent,
    LastViewsComponent
  ],
  imports: [
    CommonModule,
    BookSearchRoutingModule,
    FormsModule,
    ReactiveFormsModule
    
  ],
  exports: [
    BookContentComponent,
    BookDescriptionComponent,
    BookNotesComponent,
    BookCreateNoteComponent,
    LastViewsComponent
  ]
})

export class BookSearchModule { }
