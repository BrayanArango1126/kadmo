export default interface Membresia {
  idMembresia: number;
  tipo: string,
  estado: number;
  fechaIncio: string;
  fechaFin: string;
  pago: number;
  usuario: {
    idUsuario: number;
  }
  tarjetaCredito:{
    idTarjetaCredito: number;
  }
}