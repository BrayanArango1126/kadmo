package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.CalificacionesDTO;
import co.edu.ue.entity.Calificaciones;
import co.edu.ue.entity.Libros;

public interface ICalificacionesService {

	CalificacionesDTO addCalificaciones(Calificaciones newCalificaciones);
	CalificacionesDTO upCalificaciones(Calificaciones updateCalificaciones);
	CalificacionesDTO findIdCalificaciones(int id);
	List<CalificacionesDTO> listAllCalificaciones();
	List<CalificacionesDTO> findByIdLibro(Libros Idlibro);
}
