export default interface LibroPublicado {
  // idLibrosPublicados: number;
  // libro: {
  //   idLibros: number;
  // };
  // usuario: {
  //   idUsuario: number;
  // };

  idLibrosPublicados: number;
  libro: {
    idLibros: number;
    nombre: string;
    autor: string;
    precio: number;
    descripcion: string
    estadosLibro: {
      idEstadosLibros: number;
      estado: string;
    };
    disponibilidadLibro: {
      idDisponibilidadLibro: number;
      disponibilidad:string;
    };
    categoriasLibro: {
      idCategoriaLibro: number;
      categoria: string;
    };
  };
  usuario: {
    idUsuario: number;
    correo: string;
    contraseña: string;
    rol:{
      idRol: number;
      rol: string;
    }
  };
}