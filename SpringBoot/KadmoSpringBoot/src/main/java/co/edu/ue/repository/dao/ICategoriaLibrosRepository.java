package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.CategoriasLibros;

public interface ICategoriaLibrosRepository {
	
	CategoriasLibros insertCategoriasLibros(CategoriasLibros newCategoriasLibros);
	CategoriasLibros updateCategoriasLibros(CategoriasLibros updateCategoriasLibros);
	CategoriasLibros findIdCategoriasLibros(int id);
	List<CategoriasLibros> listCategoriasLibros();

}
