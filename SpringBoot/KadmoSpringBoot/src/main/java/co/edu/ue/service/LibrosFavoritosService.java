package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.LibrosFavoritos;
import co.edu.ue.repository.dao.ILibrosFavoritosRepository;

@Service
public class LibrosFavoritosService implements ILibrosFavoritosService{

	 @Autowired
	 ILibrosFavoritosRepository dao;

	@Override
	public LibrosFavoritos addLibrosFavoritos(LibrosFavoritos newLibrosFavoritos) {
		return this.dao.insertLibrosFavoritos(newLibrosFavoritos);
	}

	@Override
	public LibrosFavoritos upLibrosFavoritos(LibrosFavoritos updateLibrosFavoritos) {
		return this.dao.updateLibrosFavoritos(updateLibrosFavoritos);
	}

	@Override
	public LibrosFavoritos findIdLibrosFavoritos(int id) {
		return this.dao.findIdLibrosFavoritos(id);
	}

	@Override
	public List<LibrosFavoritos> listAllLibrosFavoritos() {
		return this.dao.listLibrosFavoritos();
	}
	 
}
