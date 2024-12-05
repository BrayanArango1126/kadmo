export default interface Transaccion {
    idTransaccion: number;
    libro: {
      idLibros: number;
    };
    usuario: {
      idUsuario: number;
    };
    total: number;
    estadosTransaccione: {
      idEstadoTransaccion: number;
    };
    tarjetaCredito:{
      idTarjetaCredito: number;
    },
    fechaTransaccion: string;
}