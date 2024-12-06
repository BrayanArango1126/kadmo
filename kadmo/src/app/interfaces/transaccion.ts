export default interface Transaccion {
    idTransaccion: number;
    libro: {
      idLibros: number;
      nombre?: string;
      autor?: string;
      precio?: number;
      descripcion?: string
      estadosLibro?: {
        idEstadosLibros?: number;
        estado?: string;
      };
      disponibilidadLibro?: {
        idDisponibilidadLibro?: number;
        disponibilidad?:string;
      };
      categoriasLibro?: {
        idCategoriaLibro?: number;
        categoria?: string;
      };
    };
    usuario: {
      idUsuario: number;
      correo?: string;
    };
    total: number;
    estadosTransaccione: {
      idEstadoTransaccion: number;
      estado?: string;
    };
    tarjetaCredito:{
      idTarjetaCredito: number;
    },
    fechaTransaccion: string;
}