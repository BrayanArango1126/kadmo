package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.LibrosFavoritosDTO;
import co.edu.ue.entity.LibrosFavoritos;
import co.edu.ue.entity.Usuarios;

public interface ILibrosFavoritosService {

	LibrosFavoritosDTO addLibrosFavoritos(LibrosFavoritos newLibrosFavoritos);

	LibrosFavoritosDTO upLibrosFavoritos(LibrosFavoritos updateLibrosFavoritos);

	LibrosFavoritosDTO findIdLibrosFavoritos(int id);

	List<LibrosFavoritosDTO> listAllLibrosFavoritos();

	List<LibrosFavoritosDTO> listLibrosFavoritosByUsuario(Usuarios usuario);
}
