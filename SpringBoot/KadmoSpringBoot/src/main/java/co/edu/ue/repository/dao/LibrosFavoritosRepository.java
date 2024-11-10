package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.LibrosFavoritos;
import co.edu.ue.repository.jpa.ILibrosFavoritosJPA;

@Repository
public class LibrosFavoritosRepository implements ILibrosFavoritosRepository{

	@Autowired
	ILibrosFavoritosJPA jpa;

	@Override
	public LibrosFavoritos insertLibrosFavoritos(LibrosFavoritos newLibrosFavoritos) {
		return this.jpa.save(newLibrosFavoritos);
	}

	@Override
	public LibrosFavoritos updateLibrosFavoritos(LibrosFavoritos updateLibrosFavoritos) {
		return this.jpa.save(updateLibrosFavoritos);
	}

	@Override
	public LibrosFavoritos findIdLibrosFavoritos(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<LibrosFavoritos> listLibrosFavoritos() {
		return this.jpa.findAll();
	}

	
}
