export default interface Usuario {
  idUsuario: number;
  correo: string;
  contraseña?: string;
  rol:{
    idRol: number;
    rol?: string;
  }
}