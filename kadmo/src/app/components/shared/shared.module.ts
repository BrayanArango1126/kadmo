import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageIndexComponent } from '../page-index/page-index.component';



@NgModule({
  declarations: [
    PageIndexComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    PageIndexComponent
  ]
})
export class SharedModule { }
