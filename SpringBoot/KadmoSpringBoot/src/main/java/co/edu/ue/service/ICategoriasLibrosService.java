package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.CategoriasLibros;

public interface ICategoriasLibrosService {

	CategoriasLibros addCategoriasLibros(CategoriasLibros newCategoriasLibros);
	CategoriasLibros upCategoriasLibros(CategoriasLibros updateCategoriasLibros);
	CategoriasLibros findIdCategoriasLibros(int id);
	List<CategoriasLibros> listAllCategoriasLibros();
}
