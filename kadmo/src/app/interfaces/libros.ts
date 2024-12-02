export default interface Libros {
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
}