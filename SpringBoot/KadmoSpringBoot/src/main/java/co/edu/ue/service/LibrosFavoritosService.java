package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.LibrosFavoritosDTO;
import co.edu.ue.entity.LibrosFavoritos;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.ILibrosFavoritosRepository;

@Service
public class LibrosFavoritosService implements ILibrosFavoritosService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ILibrosFavoritosRepository dao;

	@Override
	public LibrosFavoritosDTO addLibrosFavoritos(LibrosFavoritos newLibrosFavoritos) {
		LibrosFavoritos addLibro = this.dao.insertLibrosFavoritos(newLibrosFavoritos);
		LibrosFavoritosDTO librosFavoritosDTO = this.modelMapper.map(addLibro, LibrosFavoritosDTO.class);
		return librosFavoritosDTO;
	}

	@Override
	public LibrosFavoritosDTO upLibrosFavoritos(LibrosFavoritos updateLibrosFavoritos) {
		LibrosFavoritos upLibro = this.dao.updateLibrosFavoritos(updateLibrosFavoritos);
		LibrosFavoritosDTO librosFavoritosDTO = this.modelMapper.map(upLibro, LibrosFavoritosDTO.class);
		return librosFavoritosDTO;
	}

	@Override
	public LibrosFavoritosDTO findIdLibrosFavoritos(int id) {
		LibrosFavoritos idLibroFavorito = this.dao.findIdLibrosFavoritos(id);
		LibrosFavoritosDTO librosFavoritosDTO = this.modelMapper.map(idLibroFavorito, LibrosFavoritosDTO.class);
		return librosFavoritosDTO;
	}

	@Override
	public List<LibrosFavoritosDTO> listAllLibrosFavoritos() {
		List<LibrosFavoritos> listAllLibrosFavoritos = this.dao.listLibrosFavoritos();
		return listAllLibrosFavoritos.stream().map(lib -> this.modelMapper.map(lib, LibrosFavoritosDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<LibrosFavoritosDTO> listLibrosFavoritosByUsuario(Usuarios usuario) {
		List<LibrosFavoritos> listLibrosFavoritosByUsuario = this.dao.listLibrosFavoritosByUsuario(usuario);
		List<LibrosFavoritosDTO> listLibrosFavoritosDTO = listLibrosFavoritosByUsuario.stream()
				.map(lib -> this.modelMapper.map(lib, LibrosFavoritosDTO.class)).collect(Collectors.toList());
		return listLibrosFavoritosDTO;
	}

	@Override
	public String deleteLibrosFavoritos(LibrosFavoritos deleteLibrosFavoritos) {
		this.dao.deleteLibrosFavoritos(deleteLibrosFavoritos);
		return "Libro eliminado";
	}

}
