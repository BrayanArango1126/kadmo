import { Component, OnInit } from '@angular/core';
import CategoriaLibro from '../../../../interfaces/categoriaLibro';
import { CategoriasService } from '../../../../services/categorias.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {

  //Paginación
  items: any[] = []; // Lista completa de elementos
  currentPage: number = 1; // Página actual
  itemsPerPage: number = 7; // Elementos por página
  totalItems: number = 0; // Total de elementos

  categories: CategoriaLibro[] = [];
  
  formCategory!:FormGroup;
  constructor(private _categoryService: CategoriasService, private fb:FormBuilder) {
    this.formCategory = this.fb.group({
      idCategorias: [''],
      nombre: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.getCategories();
  }

  onPageChange(page: number): void {
    this.currentPage = page; // Cambia la página actual
  }

  public cleandForm(){
    this.formCategory.reset();
  }

  public getCategories(){
    this._categoryService.getCategories().subscribe({
      next: (result) => {
        this.categories = result;
        this.totalItems = this.categories.length;
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  public saveCategory(){
    const request: CategoriaLibro = {
      idCategoriaLibro: 0,
      categoria: this.formCategory.value.nombre
    }
    this._categoryService.saveCategory(request).subscribe({
      next: (result) => {
        alert('Categoria agregada correctamente');
        this.getCategories();
        this.cleandForm();
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  public sendInfo(categoryId: number){
    let category = this.categories.find((category) => category.idCategoriaLibro === categoryId);
    this.formCategory.setValue({
      idCategorias: category?.idCategoriaLibro,
      nombre: category?.categoria
    });
  }

  public updateCategory(){
    const request: CategoriaLibro = {
      idCategoriaLibro: this.formCategory.value.idCategorias,
      categoria: this.formCategory.value.nombre
    }
    this._categoryService.updateCategory(request).subscribe({
      next: (result) => {
        alert('Categoria actualizada correctamente');
        this.getCategories();
        this.cleandForm();
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

}
