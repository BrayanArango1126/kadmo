package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.LibrosFavoritos;

public interface ILibrosFavoritosService {

	LibrosFavoritos addLibrosFavoritos(LibrosFavoritos newLibrosFavoritos);
	LibrosFavoritos upLibrosFavoritos(LibrosFavoritos updateLibrosFavoritos);
	LibrosFavoritos findIdLibrosFavoritos(int id);
	List<LibrosFavoritos> listAllLibrosFavoritos();
}
