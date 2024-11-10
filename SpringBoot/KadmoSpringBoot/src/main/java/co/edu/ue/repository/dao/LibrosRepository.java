package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Libros;
import co.edu.ue.repository.jpa.ILibrosJPA;

@Repository
public class LibrosRepository implements ILibrosRepository{

	@Autowired
	ILibrosJPA jpa;
	
	@Override
	public Libros insertLibros(Libros newLibros) {
		return this.jpa.save(newLibros);
	}

	@Override
	public Libros updateLibros(Libros updateLibros) {
		return this.jpa.save(updateLibros);
	}

	@Override
	public Libros findIdLibros(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<Libros> listLibros() {
		return this.jpa.findAll();
	}

}
