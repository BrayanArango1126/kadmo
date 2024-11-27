import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoreComponent } from './store.component';
import { BooksComponent } from './books/books.component';
import { BookSearchComponent } from './book-search/book-search.component';

const routes: Routes = [
  {path:'', component: StoreComponent},
  {path:'books', component: BooksComponent},
  {path:'book/id', component: BookSearchComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StoreRoutingModule { }
