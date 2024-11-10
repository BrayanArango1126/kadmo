package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.repository.jpa.ICategoriaLibroJPA;

@Repository
public class CategoriasLibrosRepository implements ICategoriaLibrosRepository{
	
	@Autowired
	ICategoriaLibroJPA jpa;

	@Override
	public CategoriasLibros insertCategoriasLibros(CategoriasLibros newCategoriasLibros) {
		return this.jpa.save(newCategoriasLibros);
	}

	@Override
	public CategoriasLibros updateCategoriasLibros(CategoriasLibros updateCategoriasLibros) {
		return this.jpa.save(updateCategoriasLibros);
	}

	@Override
	public CategoriasLibros findIdCategoriasLibros(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<CategoriasLibros> listCategoriasLibros() {
		return this.jpa.findAll();
	}

}
