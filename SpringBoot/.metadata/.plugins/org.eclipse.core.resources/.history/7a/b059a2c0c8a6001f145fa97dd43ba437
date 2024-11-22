package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Libros;
import co.edu.ue.repository.dao.ILibrosRepository;

@Service
public class LibrosService implements ILibrosService{

	@Autowired
	ILibrosRepository dao;

	@Override
	public Libros addLibros(Libros newLibros) {
		return this.dao.insertLibros(newLibros);
	}

	@Override
	public Libros upLibros(Libros updateLibros) {
		return this.dao.updateLibros(updateLibros);
	}

	@Override
	public Libros findIdLibros(int id) {
		return this.dao.findIdLibros(id);
	}

	@Override
	public List<Libros> listAllLibros() {
		return this.dao.listLibros();
	}
	
}
