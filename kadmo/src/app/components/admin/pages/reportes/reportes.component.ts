import { Component, OnInit } from '@angular/core';
import Transaccion from '../../../../interfaces/transaccion';
import { ReportesService } from '../../../../services/reportes.service';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TransaccionesService } from '../../../../services/transacciones.service';


@Component({
  selector: 'app-reportes',
  templateUrl: './reportes.component.html',
  styleUrls: ['./reportes.component.css']
})
export class ReportesComponent implements OnInit {

  //Paginación
  items: any[] = []; // Lista completa de elementos
  currentPage: number = 1; // Página actual
  itemsPerPage: number = 5; // Elementos por página
  totalItems: number = 0; // Total de elementos
  
  transaction: Transaccion[] = [];
  formularioFiltro: FormGroup;

  constructor(private _reportesService: ReportesService, private _transaccionesService:TransaccionesService, private fb: FormBuilder) {
    this.formularioFiltro = this.fb.group({
      fechaInicio:['', Validators.required],
      fechaFin:['', Validators.required]
    })
   }
  ngOnInit(): void {
    this.getAllTransacciones();
  }

  onPageChange(page: number): void {
    this.currentPage = page; // Cambia la página actual
  }
  public getAllTransacciones(){
    this._reportesService.getAllTransacciones().subscribe({
      next: (data) => {
        this.transaction = data;
        this.totalItems = this.transaction.length;
      },
      error: (error) => {
        console.log(error);
      }
    })
  }

  public getTransaccionExcel(){
    const fechaInicio = this.formularioFiltro.get('fechaInicio')?.value;
    const fechaFin = this.formularioFiltro.get('fechaFin')?.value;
    this._transaccionesService.getTransaccionExcel(fechaInicio, fechaFin).subscribe({
      next: (data) => {
        const blob = new Blob([data], {type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'});
        const url = window.URL.createObjectURL(blob);
        window.open(url);
      },
      error: (error) => {
        console.log(error);
      }
    })
  }
  

}
