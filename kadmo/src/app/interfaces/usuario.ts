export default interface Usuario {
  idUsuario: number;
  correo: string;
  contraseña: string;
  role:{
    idRol: number;
  }
}