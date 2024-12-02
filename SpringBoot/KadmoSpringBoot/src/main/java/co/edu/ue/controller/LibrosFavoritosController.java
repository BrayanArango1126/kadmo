package co.edu.ue.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.dto.LibrosFavoritosDTO;
import co.edu.ue.dto.UsuariosDTO;
import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.entity.DisponibilidadLibros;
import co.edu.ue.entity.EstadosLibros;
import co.edu.ue.entity.Libros;
import co.edu.ue.entity.LibrosFavoritos;
import co.edu.ue.entity.Roles;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.ICategoriaLibrosRepository;
import co.edu.ue.repository.dao.IDisponibilidadLibrosRepository;
import co.edu.ue.repository.dao.IEstadosLibrosRepository;
import co.edu.ue.repository.dao.ILibrosRepository;
import co.edu.ue.repository.dao.IRolRepository;
import co.edu.ue.repository.dao.IUsuarioRepository;
import co.edu.ue.service.ILibrosFavoritosService;
import co.edu.ue.utils.ApiResponse;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "libro-favorito")

public class LibrosFavoritosController {

	@Autowired
	private IEstadosLibrosRepository dao;

	@Autowired
	private IDisponibilidadLibrosRepository daoDisponibilidad;

	@Autowired
	private ICategoriaLibrosRepository daoCategory;

	@Autowired
	private IRolRepository daoRol;

	@Autowired
	private IUsuarioRepository daoUser;

	@Autowired
	private ILibrosRepository daoLibro;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ILibrosFavoritosService service;

	@GetMapping(value = "libros-favoritos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LibrosFavoritosDTO>> getAllLibrosFavoritos() {
		return new ResponseEntity<List<LibrosFavoritosDTO>>(this.service.listAllLibrosFavoritos(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "libro-favorito-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibrosFavoritosDTO> getByIdLibrosFavoritos(@RequestParam("idLibroFavorito") int id) {
		return new ResponseEntity<LibrosFavoritosDTO>(this.service.findIdLibrosFavoritos(id), HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "libros-favoritos-id-usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LibrosFavoritosDTO>> postMethodName(@RequestBody UsuariosDTO usuario) {
		Usuarios user = this.modelMapper.map(usuario, Usuarios.class);
		List<LibrosFavoritosDTO> librosFav = this.service.listLibrosFavoritosByUsuario(user);
		return new ResponseEntity<List<LibrosFavoritosDTO>>(librosFav, HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "add-libro-favorito", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<LibrosFavoritosDTO>> postLibrosFavoritos(
			@RequestBody LibrosFavoritosDTO newLibrosFavoritos) {
		LibrosFavoritos addLibrosFavoritos = this.modelMapper.map(newLibrosFavoritos, LibrosFavoritos.class);

		Usuarios user = this.daoUser.findIdUsuario(newLibrosFavoritos.getUsuario().getIdUsuario());
		Roles rol = this.daoRol.findIdRol(user.getRole().getIdRol());
		Libros libro = this.daoLibro.findIdLibros(newLibrosFavoritos.getLibro().getIdLibros());
		EstadosLibros estado = this.dao.findIdEstadosLibros(libro.getEstadoslibro().getIdEstadosLibros());
		CategoriasLibros categoria = this.daoCategory
				.findIdCategoriasLibros(libro.getCategoriaslibro().getIdCategoriaLibro());
		DisponibilidadLibros disponibilidad = this.daoDisponibilidad
				.findIdDisponibilidadLibros(libro.getDisponibilidadlibro().getIdDisponibilidadLibro());

		libro.setDisponibilidadlibro(disponibilidad);
		libro.setCategoriaslibro(categoria);
		libro.setEstadoslibro(estado);

		user.setRole(rol);
		addLibrosFavoritos.setUsuario(user);
		addLibrosFavoritos.setLibro(libro);

		LibrosFavoritosDTO addedLibrosFavoritos = this.service.addLibrosFavoritos(addLibrosFavoritos);
		return new ResponseEntity<>(new ApiResponse<>("Libro añadido a favoritos", addedLibrosFavoritos),
				HttpStatus.CREATED);
	}

	@PutMapping(value = "update-libro-favorito", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibrosFavoritosDTO> putLibrosFavoritos(@RequestBody LibrosFavoritosDTO updateLibrosFavoritos) {
		LibrosFavoritos updLibrosFavoritos = this.modelMapper.map(updateLibrosFavoritos, LibrosFavoritos.class);
		LibrosFavoritosDTO updatedLibrosFavoritos = this.service.upLibrosFavoritos(updLibrosFavoritos);
		return new ResponseEntity<LibrosFavoritosDTO>(updatedLibrosFavoritos, HttpStatus.OK);
	}
}
