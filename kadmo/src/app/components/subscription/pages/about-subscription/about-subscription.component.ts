import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup,Validators } from '@angular/forms';

import { MembresiasService } from '../../../../services/membresias.service';
import { TarjetasCreditoService } from '../../../../services/tarjetas-credito.service';

import Membresia from '../../../../interfaces/membresia';
import TarjetaCredito from '../../../../interfaces/tarjetaCredito';
import Usuario from '../../../../interfaces/usuario';

import { infoAlert, redirectActivedAlert } from '../../../../../assets/alerts';
import { environment } from '../../../../../environments/environment';
import * as cryptoJS from 'crypto-js';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-about-subscription',
  templateUrl: './about-subscription.component.html',
  styleUrl: './about-subscription.component.css'
})
export class AboutSubscriptionComponent {

   fechaInicio:Date = new Date();
   fechaFin:Date = new Date();
   listCreditCards:TarjetaCredito[] = [];
   selectedCreditCard!:TarjetaCredito;

  idUser:string = localStorage.getItem('user') || '0';
  membershipForm!: FormGroup;
  creditCardForm!: FormGroup;
  constructor(
    private _membresiaService:MembresiasService, 
    private fb:FormBuilder,
    private _tarjetaCreditoService:TarjetasCreditoService,
    private fbCreditCard:FormBuilder
  ) {
    this.idUser = (this.idUser != '0' ) ? cryptoJS.AES.decrypt(this.idUser, environment.cryptPassword).toString(cryptoJS.enc.Utf8) : '0';
    this.membershipForm = this.fb.group(
      {
        tipo: ['MENSUAL', Validators.required],
        pago: ['45000', Validators.required]
      }
    );
    this.creditCardForm = this.fbCreditCard.group(
      {
        titular: ['', Validators.required],
        numeroTarjeta: ['', Validators.required],
        fechaExpiracion: ['', Validators.required],
        cvs: ['', Validators.required],
        usuario: {
          idUsuario: parseInt(this.idUser) || 0
        }
      }
    );
   }

  ngOnInit(): void {
    this.getAllCreditCards();
    this.membershipForm.get('tipo')?.valueChanges.subscribe(value => {
      // Lógica para actualizar relatedValue en función de value
      if (value === 'MENSUAL') {
        this.membershipForm.get('pago')?.setValue('45000');
      } else if (value === 'ANUAL') {
        this.membershipForm.get('pago')?.setValue('500000');
      }
    });
  }

  onChangeCreditCard(card:TarjetaCredito) {
    this.selectedCreditCard = card;
    // console.log(card);
  }

  public verifyUserLogin() {
    if (this.idUser === '0' || this.idUser === null) {
      redirectActivedAlert("info", "Sesión no encontrada", "login", "suscripcion");
    }

    const modalElement = document.getElementById('exampleModalToggle');
    if (modalElement) {
      const modal = new bootstrap.Modal(modalElement);
      modal.show();
    } else {
      console.error('Modal element not found');
    }
  }

  public getAllCreditCards() {
    if(this.idUser == '0') return;
    const request:Usuario = {
      idUsuario: parseInt(this.idUser) || 0,
      correo: '',
      contraseña: '',
      rol: {
        idRol: 0
      }
    }
    this._tarjetaCreditoService.getTarjetasCreditoByUserId(request).subscribe({
      next: (data) => {
        this.listCreditCards = data;
      },
      error: (error) => {
        console.log(error);
      }
    });
  }

  public registerMembership() {
    if(!this.selectedCreditCard) {
      return infoAlert("error", "Error", "Seleccione una tarjeta de crédito");
    }
    if(this.membershipForm.value.tipo === 'MENSUAL') {
      this.fechaFin.setMonth(this.fechaInicio.getMonth() + 1);
    }else{
      this.fechaFin.setFullYear(this.fechaInicio.getFullYear() + 1);
    }
    const request:Membresia = {
      idMembresia: 0,
      usuario: {
        idUsuario: parseInt(this.idUser) || 0
      },
      fechaIncio: this.fechaInicio.toISOString(),
      fechaFin: this.fechaFin.toISOString(),
      estado: 1,
      tipo: this.membershipForm.value.tipo,
      pago: this.membershipForm.value.pago,
      tarjetaCredito:{
        idTarjetaCredito: this.selectedCreditCard.idTarjetaCredito
      }
    }
    // console.log(request);
    this._membresiaService.createMembresia(request).subscribe({
      next: (data) => {
        infoAlert("success", "Operación exitosa", "Membresia registrada con éxito");
        // window.location.href = '/store';
      },
      error: (error) => {
        infoAlert("error","Operación fallida", 'Error al registrar la membresia');
      }
    });
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
        idUsuario: parseInt(this.idUser) || 0
      }
    }
    // console.log(request);
    this._tarjetaCreditoService.createTarjetaCredito(request).subscribe({
      next: (data) => {
        infoAlert("success","operación exitosa",data.message);
        this.getAllCreditCards();
      },
      error: (error) => {
        infoAlert("error","Operación fallida",'Error al registrar la tarjeta de crédito');
      }
    });
  }


}
