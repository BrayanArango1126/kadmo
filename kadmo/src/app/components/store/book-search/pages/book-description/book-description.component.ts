import { Component, Input } from '@angular/core';
import { TransaccionesService } from '../../../../../services/transacciones.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Transaccion from '../../../../../interfaces/transaccion';
import { Alert } from 'bootstrap';
import CalificacionLibro from '../../../../../interfaces/calificacionLibro';
import Usuario from '../../../../../interfaces/usuario';
import { TarjetasCreditoService } from '../../../../../services/tarjetas-credito.service';
import TarjetaCredito from '../../../../../interfaces/tarjetaCredito';
import * as bootstrap from 'bootstrap';
import { LibrosService } from '../../../../../services/libros.service';
import Libros from '../../../../../interfaces/libros';

@Component({
  selector: 'app-book-description',
  templateUrl: './book-description.component.html',
  styleUrl: './book-description.component.css',
  standalone: false

})
export class BookDescriptionComponent {

  @Input() infoLibro:CalificacionLibro[] = [];
  @Input() book!:Libros;
  @Input() libroProp: Libros[] = [];
  idUsuario = localStorage.getItem('user') || '0';
  listAllCreditCards:TarjetaCredito[] = [];
  selectedCreditCard!:TarjetaCredito;

  formCompraLibros!:FormGroup;
  creditCardForm!:FormGroup;
  constructor(
    private _transaccionService:TransaccionesService, 
    private _tarjetaCreditoService:TarjetasCreditoService,
    private fbCreditCard:FormBuilder,
    private fbBuyBook:FormBuilder,
    private _librosService:LibrosService
  ) 
  {
    this.formCompraLibros = this.fbBuyBook.group({

    });
    this.creditCardForm = this.fbCreditCard.group(
      {
        titular: ['', Validators.required],
        numeroTarjeta: ['', Validators.required],
        fechaExpiracion: ['', Validators.required],
        cvs: ['', Validators.required],
        usuario: {
          idUsuario: parseInt(this.idUsuario) || 0
        }
      }
    );
   }


  ngOnInit(): void {
    this.getAllCreditCards();
  }

  public onChangeCreditCard(card:TarjetaCredito) {
    this.selectedCreditCard = card;
    // console.log(card);
  }
  public comprarLibro(){
    if(!this.formCompraLibros.valid){
      alert('Por favor llene todos los campos');
      return;
    }
    if(!this.selectedCreditCard){
      alert('Por favor seleccione una tarjeta de crédito');
      return;
    }

    const request:Transaccion = {
      idTransaccion: 0,
      estadosTransaccione: {
        idEstadoTransaccion: 1
      },
      tarjetaCredito: {
        idTarjetaCredito: this.selectedCreditCard.idTarjetaCredito
      },
      libro: {
        idLibros: this.book.idLibros
      },
      usuario: {
        idUsuario: parseInt(this.idUsuario)
      },
      total: this.book.precio,
      fechaTransaccion: new Date().toISOString()
    }

    console.log(request);

    this._transaccionService.addTransaccion(request).subscribe({
      next: (res) => {
        alert('Compra realizada con éxito');
        this.updateEstateBook();
      },
      error: (error) => {
        console.log(error);
      }
    });
  }

  public getAllCreditCards() {
    const request:Usuario = {
      idUsuario: parseInt(this.idUsuario) || 0,
      correo: '',
      contraseña: '',
      rol: {
        idRol: 0
      }
    }
    this._tarjetaCreditoService.getTarjetasCreditoByUserId(request).subscribe({
      next: (data) => {
        this.listAllCreditCards = data;
      },
      error: (error) => {
        console.log(error);
      }
    });
  }

  public verifyUserLogin() {
    if (this.idUsuario === '0' || this.idUsuario === null) {
      alert('Debes Iniciar Sesión o registrarte para poder continuar');
      window.location.href = '/login';
    }

    const modalElement = document.getElementById('buyBookModal');
    if (modalElement) {
      const modal = new bootstrap.Modal(modalElement);
      modal.show();
    } else {
      console.error('Modal element not found');
    }
  }

  public addCreditCard() {
    if(this.creditCardForm.invalid) return;
    const request:TarjetaCredito = {
      idTarjetaCredito: 0,
      titular: this.creditCardForm.value.titular,
      numeroTarjeta: this.creditCardForm.value.numeroTarjeta,
      fechaExpiracion: this.creditCardForm.value.fechaExpiracion,
      cvs: this.creditCardForm.value.cvs,
      usuario: {
        idUsuario: parseInt(this.idUsuario) || 0
      }
    }
    // console.log(request);
    this._tarjetaCreditoService.createTarjetaCredito(request).subscribe({
      next: (data) => {
        alert(data.message);
        this.getAllCreditCards();
      },
      error: (error) => {
        alert('Error al registrar la tarjeta de crédito');
      }
    });
  }

  public updateEstateBook(){
    const request:Libros = {
      idLibros: this.book.idLibros,
      nombre: this.book.nombre,
      autor: this.book.autor,
      precio: this.book.precio,
      descripcion: this.book.descripcion,
      estadosLibro: {
        idEstadosLibros: this.book.estadosLibro.idEstadosLibros,
        estado: ''
      },
      categoriasLibro: {
        idCategoriaLibro: this.book.categoriasLibro.idCategoriaLibro,
        categoria: ''
      },
      disponibilidadLibro: {
        idDisponibilidadLibro: 2,
        disponibilidad: ''
      }
    }
    console.log(request);
    this._librosService.updateLibro(request).subscribe({
      next: (data) => {
        alert("Libro a tu disposición para envío");
      },
      error: (error) => {
        console.log(error);
      }
    });
  }


}
