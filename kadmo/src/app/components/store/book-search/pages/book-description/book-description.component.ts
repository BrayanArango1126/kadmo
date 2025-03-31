import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
// import { Alert } from 'bootstrap';
import CalificacionLibro from '../../../../../interfaces/calificacionLibro';
import TarjetaCredito from '../../../../../interfaces/tarjetaCredito';
import Transaccion from '../../../../../interfaces/transaccion';
import Usuario from '../../../../../interfaces/usuario';
import Libros from '../../../../../interfaces/libros';
import { ChangeDetectorRef } from '@angular/core';

import { TarjetasCreditoService } from '../../../../../services/tarjetas-credito.service';
import { TransaccionesService } from '../../../../../services/transacciones.service';
import { LibrosService } from '../../../../../services/libros.service';
import { environment } from '../../../../../../environments/environment';

import {
  redirectAlert,
  redirectActivedAlert,
  infoAlert,
} from '../../../../../../assets/alerts';
import * as bootstrap from 'bootstrap';
import * as cryptoJS from 'crypto-js';
import * as bcrypt from 'bcryptjs';
import { EthereumService } from '../../../../../services/ethereum.service';

@Component({
  selector: 'app-book-description',
  templateUrl: './book-description.component.html',
  styleUrl: './book-description.component.css',
  standalone: false,
})
export class BookDescriptionComponent {
  @Input() infoLibro: CalificacionLibro[] = [];
  @Input() book!: Libros;
  @Input() libroProp: Libros[] = [];
  @ViewChild('toAddressInput') toAddressInput!: ElementRef;
  @ViewChild('amountInput') amountInput!: ElementRef;

  idUsuario = localStorage.getItem('user') || '0';
  listAllCreditCards: TarjetaCredito[] = [];
  selectedCreditCard!: TarjetaCredito;

  transactionHash: string = '';

  toAddress: string = '';
  amount: number = 0;
  userKey: string = '';

  formCompraLibros!: FormGroup;
  creditCardForm!: FormGroup;
  constructor(
    private _transaccionService: TransaccionesService,
    private _tarjetaCreditoService: TarjetasCreditoService,
    private fbCreditCard: FormBuilder,
    private fbBuyBook: FormBuilder,
    private _librosService: LibrosService,
    private _route: ActivatedRoute,
    private _ethereumService: EthereumService,
    private cdr: ChangeDetectorRef
  ) {
    this.idUsuario =
      this.idUsuario != '0'
        ? cryptoJS.AES.decrypt(
            this.idUsuario,
            environment.cryptPassword
          ).toString(cryptoJS.enc.Utf8)
        : '0';
    this.formCompraLibros = this.fbBuyBook.group({});
    this.creditCardForm = this.fbCreditCard.group({
      titular: ['', Validators.required],
      numeroTarjeta: ['', Validators.required],
      fechaExpiracion: ['', Validators.required],
      cvs: ['', Validators.required],
      usuario: {
        idUsuario: parseInt(this.idUsuario) || 0,
      },
    });
  }

  ngOnInit(): void {
    this.getAllCreditCards();
  }

  // async sendTransaction() {
  //   try {
  //     this.toAddress = '0x983eb2EeF77d44933914e714eC233Eed69e36A1F'; // 💡 Dirección de prueba
  //     this.amount = 0.01; // 💡 Monto de prueba
  //     await this._ethereumService.connectWallet(); // 💡 Primero conectamos MetaMask

  //     const hash = await this._ethereumService.sendPayment(
  //       this.toAddress,
  //       this.amount
  //     );

  //     if (hash) {
  //       this.transactionHash = hash;
  //       console.log('Transacción confirmada:', hash);
  //     }
  //   } catch (error) {
  //     console.error('Error al enviar la transacción:', error);
  //   }
  // }

  async sendTransaction() {
    const toAddress = this.toAddressInput.nativeElement.value;
    const amount = parseFloat(this.amountInput.nativeElement.value);

    console.log('Datos capturados:', toAddress, amount);

    if (!toAddress || amount <= 0) {
      alert('Ingrese una dirección válida y un monto mayor a 0');
      return;
    }

    try {
      await this._ethereumService.connectWallet();
      const hash = await this._ethereumService.sendPayment(toAddress, amount);

      if (hash) {
        this.transactionHash = hash;
        console.log('Transacción confirmada:', hash);
      }
    } catch (error) {
      console.error('Error al enviar la transacción:', error);
    }
  }

  public onChangeCreditCard(card: TarjetaCredito) {
    this.selectedCreditCard = card;
    // console.log(card);
  }
  public async comprarLibro() {
    if (!this.formCompraLibros.valid) {
      redirectAlert('info', 'Inicie sesión primero', 'login');
      return;
    }
    if (!this.selectedCreditCard) {
      infoAlert(
        'info',
        'No ha seleccionado medio de pago',
        'Por favor seleccione una tarjeta de crédito'
      );
      return;
    }

    const pass1 = this.selectedCreditCard.usuario.contraseña || '';
    const isPasswordValid = await this.compareCrypt(pass1);
    if (!isPasswordValid) {
    return;
    }
    const request: Transaccion = {
      idTransaccion: 0,
      estadosTransaccione: {
        idEstadoTransaccion: 1,
      },
      tarjetaCredito: {
        idTarjetaCredito: this.selectedCreditCard.idTarjetaCredito,
      },
      libro: {
        idLibros: this.book.idLibros,
      },
      usuario: {
        idUsuario: parseInt(this.idUsuario),
      },
      total: this.book.precio,
      fechaTransaccion: new Date().toISOString(),
    };

    console.log(request);

    this._transaccionService.addTransaccion(request).subscribe({
      next: async (res) => {
        await infoAlert('success', 'exito', 'Compra realizada con éxito');
        this.updateEstateBook();
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  public getAllCreditCards() {
    const request: Usuario = {
      idUsuario: parseInt(this.idUsuario) || 0,
      correo: '',
      contraseña: '',
      rol: {
        idRol: 0,
      },
    };
    this._tarjetaCreditoService.getTarjetasCreditoByUserId(request).subscribe({
      next: (data) => {
        this.listAllCreditCards = data;
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  public verifyUserLogin() {
    if (this.idUsuario === '0' || this.idUsuario === null) {
      redirectActivedAlert(
        'info',
        'Sesión no encontrada',
        'login',
        '/store/book/' + encodeURIComponent(this._route.snapshot.params['id'])
      );
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
    if (this.creditCardForm.invalid) return;
    const request: TarjetaCredito = {
      idTarjetaCredito: 0,
      titular: this.creditCardForm.value.titular,
      numeroTarjeta: this.creditCardForm.value.numeroTarjeta,
      fechaExpiracion: this.creditCardForm.value.fechaExpiracion,
      cvs: this.creditCardForm.value.cvs,
      usuario: {
        idUsuario: parseInt(this.idUsuario) || 0,
      },
    };
    // console.log(request);
    this._tarjetaCreditoService.createTarjetaCredito(request).subscribe({
      next: (data) => {
        infoAlert('success', 'Exito', data.message);
        this.getAllCreditCards();
      },
      error: (error) => {
        alert('Error al registrar la tarjeta de crédito');
      },
    });
  }

  public updateEstateBook() {
    const request: Libros = {
      idLibros: this.book.idLibros,
      nombre: this.book.nombre,
      autor: this.book.autor,
      precio: this.book.precio,
      descripcion: this.book.descripcion,
      estadosLibro: {
        idEstadosLibros: this.book.estadosLibro.idEstadosLibros,
        estado: '',
      },
      categoriasLibro: {
        idCategoriaLibro: this.book.categoriasLibro.idCategoriaLibro,
        categoria: '',
      },
      disponibilidadLibro: {
        idDisponibilidadLibro: 2,
        disponibilidad: '',
      },
    };
    console.log(request);
    this._librosService.updateLibro(request).subscribe({
      next: (data) => {
        infoAlert('info', '¡En camino!','Libro a tu disposición para envío');
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  public async compareCrypt(pass1:string): Promise<boolean> {
    try {
      const result = await bcrypt.compare(this.userKey, pass1);
      if(result==false) await infoAlert('error','Error','La clave es incorrecta');
      
      return result;
    
    } catch (err) {
      console.error('Error al comparar la clave:', err);
      infoAlert('error', 'Error', 'Ocurrió un error al verificar la clave');
      return false;
    }
  }
}
