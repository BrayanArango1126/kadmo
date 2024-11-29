export default interface DatosUsuario {
  idDatoUsuario: number;
  nombres: string;
  apellidos: string;
  direccion: string;
  documento: string;
  telefono: string;
  edad: number;
  usuarioVerificado: number;
  genero: {
    idGenero: number;
  };
  usuario: {
    idUsuario: number;
  }
}