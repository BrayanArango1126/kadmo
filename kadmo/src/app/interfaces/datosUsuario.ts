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
    genero: string;
  };
  usuario: {
    idUsuario: number;
    correo: string;
    rol: {
      idRol: number;
      rol: string;
    };
  }
  
}