package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Calificaciones;
import co.edu.ue.repository.dao.ICalificacionesRepository;

@Service
public class CalificacionesService implements ICalificacionesService{

	@Autowired
	ICalificacionesRepository dao;

	@Override
	public Calificaciones addCalificaciones(Calificaciones newCalificaciones) {
		return this.dao.insertCalificaciones(newCalificaciones);
	}

	@Override
	public Calificaciones upCalificaciones(Calificaciones updateCalificaciones) {
		return this.dao.updateCalificaciones(updateCalificaciones);
	}

	@Override
	public Calificaciones findIdCalificaciones(int id) {
		return this.dao.findIdCalificaciones(id);
	}

	@Override
	public List<Calificaciones> listAllCalificaciones() {
		return this.dao.listCalificaciones();
	}
	
	
}
