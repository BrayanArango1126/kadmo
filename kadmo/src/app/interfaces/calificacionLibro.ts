export default interface CalificacionLibro {
  idCalificacion: number;
  libro: {
    idLibros: number;
  };
  usuario: {
    idUsuario: number;
  };
  comentario: string;
  puntuacion: number;
}