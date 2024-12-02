import { Component, OnInit } from '@angular/core';
import CategoriaLibro from '../../../../interfaces/categoriaLibro';
import { CategoriasService } from '../../../../services/categorias.service';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {
  categories: CategoriaLibro[] = [];
  
  constructor(private categoryService: CategoriasService) {}

  ngOnInit(): void {
    this.categoryService.getCategories().subscribe(data => {
      this.categories = data;
    });
  }
}
