export default interface Libros {
  idLibros: number;
  nombre: string;
  autor: string;
  precio: number;
  descripcion: string
  estadosLibro: {
    idEstadosLibros: number;
  };
  disponibilidadLibro: {
    idDisponibilidadLibro: number;
  };
  categoriasLibro: {
    idCategoriaLibro: number;
  };
}