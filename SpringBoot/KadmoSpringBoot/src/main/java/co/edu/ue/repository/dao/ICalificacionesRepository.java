package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Calificaciones;
import co.edu.ue.entity.Libros;

public interface ICalificacionesRepository {

	Calificaciones insertCalificaciones(Calificaciones newCalificaciones);
	Calificaciones updateCalificaciones(Calificaciones updateCalificaciones);
	Calificaciones findIdCalificaciones(int id);
	List<Calificaciones> listCalificaciones();
	List<Calificaciones> findByIdLibro(Libros idLibro);
}
