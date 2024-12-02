package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Calificaciones;
import co.edu.ue.entity.Libros;
import co.edu.ue.repository.jpa.ICalificacionesJPA;

@Repository
public class CalificacionesRepository implements ICalificacionesRepository {

	@Autowired
	ICalificacionesJPA jpa;

	@Override
	public Calificaciones insertCalificaciones(Calificaciones newCalificaciones) {
		return this.jpa.save(newCalificaciones);
	}

	@Override
	public Calificaciones updateCalificaciones(Calificaciones updateCalificaciones) {
		return this.jpa.save(updateCalificaciones);
	}

	@Override
	public Calificaciones findIdCalificaciones(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<Calificaciones> listCalificaciones() {
		return this.jpa.findAll();
	}
	
	@Override
	public List<Calificaciones> findByIdLibro(Libros libro) {
		return this.jpa.findByLibro(libro);
	}
	
}
