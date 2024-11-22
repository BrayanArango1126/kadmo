package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.repository.dao.ICategoriaLibrosRepository;

@Service
public class CategoriasLibrosService implements ICategoriasLibrosService{

	@Autowired
	ICategoriaLibrosRepository dao;
	
	@Override
	public CategoriasLibros addCategoriasLibros(CategoriasLibros newCategoriasLibros) {
		return this.dao.insertCategoriasLibros(newCategoriasLibros);
	}

	@Override
	public CategoriasLibros upCategoriasLibros(CategoriasLibros updateCategoriasLibros) {
		return this.dao.updateCategoriasLibros(updateCategoriasLibros);
	}

	@Override
	public CategoriasLibros findIdCategoriasLibros(int id) {
		return this.dao.findIdCategoriasLibros(id);
	}

	@Override
	public List<CategoriasLibros> listAllCategoriasLibros() {
		return this.dao.listCategoriasLibros();
	}

	
}
