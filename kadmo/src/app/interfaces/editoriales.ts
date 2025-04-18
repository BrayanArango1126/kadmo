export default interface Editorial {
  idEditoriales: number;
  direccion: string;
  nombre: string;
  telefono: string;
  usuario: {
    idUsuario: number;
    correo: string;
    contraseña: string;
    rol: {
      idRol: number;
    };
  };
}