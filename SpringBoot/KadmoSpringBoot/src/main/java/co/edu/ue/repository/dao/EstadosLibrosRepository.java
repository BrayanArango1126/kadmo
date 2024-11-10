package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.EstadosLibros;
import co.edu.ue.repository.jpa.IEstadosLibrosJPA;

@Repository
public class EstadosLibrosRepository implements IEstadosLibrosRepository{

	@Autowired
	IEstadosLibrosJPA jpa;
	
	@Override
	public EstadosLibros insertEstadosLibros(EstadosLibros newEstadosLibros) {
		return this.jpa.save(newEstadosLibros);
	}

	@Override
	public EstadosLibros updateEstadosLibros(EstadosLibros updateEstadosLibros) {
		return this.jpa.save(updateEstadosLibros);
	}

	@Override
	public EstadosLibros findIdEstadosLibros(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<EstadosLibros> listEstadosLibros() {
		return this.jpa.findAll();
	}

}
