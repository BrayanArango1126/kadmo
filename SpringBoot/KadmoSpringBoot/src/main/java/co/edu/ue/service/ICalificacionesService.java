package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Calificaciones;

public interface ICalificacionesService {

	Calificaciones addCalificaciones(Calificaciones newCalificaciones);
	Calificaciones upCalificaciones(Calificaciones updateCalificaciones);
	Calificaciones findIdCalificaciones(int id);
	List<Calificaciones> listAllCalificaciones();
}
