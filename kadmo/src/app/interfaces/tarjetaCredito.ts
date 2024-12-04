export default interface TarjetaCredito {
  idTarjetaCredito: number;
  titular: string;
  numeroTarjeta: string;
  fechaExpiracion: string;
  cvs: string;
  usuario: {
    idUsuario: number;
  };
}