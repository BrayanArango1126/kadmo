import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListsRoutingModule } from './lists-routing.module';
import { AuthorInfoComponent } from './pages/author-info/author-info.component';
import { ListsComponent } from './lists.component';
import { ListInfoComponent } from './pages/list-info/list-info.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    ListsComponent,
    AuthorInfoComponent,
    ListInfoComponent,
  ],
  imports: [
    CommonModule,
    ListsRoutingModule,
    SharedModule
]
})
export class ListsModule { }
