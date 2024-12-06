package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.LibrosFavoritos;
import co.edu.ue.entity.Usuarios;

public interface ILibrosFavoritosRepository {

	LibrosFavoritos insertLibrosFavoritos(LibrosFavoritos newLibrosFavoritos);

	LibrosFavoritos updateLibrosFavoritos(LibrosFavoritos updateLibrosFavoritos);

	LibrosFavoritos findIdLibrosFavoritos(int id);

	List<LibrosFavoritos> listLibrosFavoritos();

	List<LibrosFavoritos> listLibrosFavoritosByUsuario(Usuarios usuario);

	String deleteLibrosFavoritos(LibrosFavoritos deleteLibrosFavoritos);
}
