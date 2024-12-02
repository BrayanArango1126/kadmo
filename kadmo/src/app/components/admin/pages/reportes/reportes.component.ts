import { Component, OnInit } from '@angular/core';
import Transaccion from '../../../../interfaces/transaccion';
import { ReportesService } from '../../../../services/reportes.service';

@Component({
  selector: 'app-reportes',
  templateUrl: './reportes.component.html',
  styleUrls: ['./reportes.component.css']
})
export class ReportesComponent implements OnInit {
  
  transaction: Transaccion[] = [];

  constructor(private reportesService: ReportesService) { }
  ngOnInit(): void {
    this.reportesService.getAllTransacciones().subscribe(data => {
      this.transaction = data;
    })
  }
  

}
