export default interface DatosUsuario {
  nombres: string;
  apellidos: string;
  direccion: string;
  documento: string;
  telefono: string;
  edad: string;
  genero: {
    idGenero: number;
  };
  usuarioVerificado: number;
  usuario: {
    idUsuario: number;
  }
}