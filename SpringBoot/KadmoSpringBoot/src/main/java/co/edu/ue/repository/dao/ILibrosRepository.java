package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Libros;

public interface ILibrosRepository {

	Libros insertLibros(Libros newLibros);
	Libros updateLibros(Libros updateLibros);
	Libros findIdLibros(int id);
	List<Libros> listLibros();
}
