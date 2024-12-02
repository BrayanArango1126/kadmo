import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import Libros from '../interfaces/libros';

@Injectable({
  providedIn: 'root'
})
export class LibrosSharedFiltersService {

  private librosSubject = new BehaviorSubject<Libros[]>([]);
  libros$ = this.librosSubject.asObservable();

  
  constructor() { }

  public actualizarLibros(libros: Libros[]) {
    this.librosSubject.next(libros);
  }
}
