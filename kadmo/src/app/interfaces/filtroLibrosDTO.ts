import CategoriaLibro from './categoriaLibro';
export default interface FiltroLibros {
  autor?: string;
  disponibilidadLibro?: {
    idDisponibilidadLibro: number;
    disponibilidad: string;
  }
  categoriasLibro?:CategoriaLibro[]
  estadosLibro?: {
    idEstadosLibros: number;
    estado: string;
  }
  precio?: number;
}