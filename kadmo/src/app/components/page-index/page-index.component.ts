import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-page-index',
  templateUrl: './page-index.component.html',
  styleUrl: './page-index.component.css'
})
export class PageIndexComponent {
  @Input() pageIndex?: string;
}
