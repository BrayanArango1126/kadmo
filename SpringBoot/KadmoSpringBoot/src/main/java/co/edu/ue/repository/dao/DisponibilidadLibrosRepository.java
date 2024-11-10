package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.DisponibilidadLibros;
import co.edu.ue.repository.jpa.IDisponibilidadLibroJPA;

@Repository
public class DisponibilidadLibrosRepository implements IDisponibilidadLibrosRepository{

	 @Autowired
	 IDisponibilidadLibroJPA jpa;
	
	@Override
	public DisponibilidadLibros insertDisponibilidadLibros(DisponibilidadLibros newDisponibilidadLibros) {
		return this.jpa.save(newDisponibilidadLibros);
	}

	@Override
	public DisponibilidadLibros updateDisponibilidadLibros(DisponibilidadLibros updateDisponibilidadLibros) {
		return this.jpa.save(updateDisponibilidadLibros);
	}

	@Override
	public DisponibilidadLibros findIdDisponibilidadLibros(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<DisponibilidadLibros> listDisponibilidadLibros() {
		return this.jpa.findAll();
	}

	
}
