export default interface Membresia {
  idMembresia: number;
  tipo: string,
  estado: number;
  fechaIncio: string;
  fechaFin: string;
  usuario: {
    "idUsuario": number;
  }
}