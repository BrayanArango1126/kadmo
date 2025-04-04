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

import co.edu.ue.dto.LibrosPublicadosDTO;
import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.entity.DisponibilidadLibros;
import co.edu.ue.entity.EstadosLibros;
import co.edu.ue.entity.Libros;
import co.edu.ue.entity.LibrosPublicados;
import co.edu.ue.entity.Roles;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.ICategoriaLibrosRepository;
import co.edu.ue.repository.dao.IDisponibilidadLibrosRepository;
import co.edu.ue.repository.dao.IEstadosLibrosRepository;
import co.edu.ue.repository.dao.ILibrosRepository;
import co.edu.ue.repository.dao.IRolRepository;
import co.edu.ue.repository.dao.IUsuarioRepository;
import co.edu.ue.service.ILibrosPublicadosService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="libro-publicado")
public class LibrosPublicadosController {
	
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
	ILibrosPublicadosService service;
	
	@GetMapping(value="libros-publicados", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LibrosPublicadosDTO>> getAllLibrosPublicados() {
		return new ResponseEntity<List<LibrosPublicadosDTO>> ( this.service.listAllLibrosPublicados(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="libro-publicado-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibrosPublicadosDTO> getByIdLibrosPublicados(@RequestParam("idLibroPublicado") int id) {
		return new ResponseEntity<LibrosPublicadosDTO>( this.service.findIdLibrosPublicados(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-libro-publicado", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibrosPublicadosDTO> postLibrosPublicados(@RequestBody LibrosPublicadosDTO newLibrosPublicados) {
		LibrosPublicados addLibrosPublicados = this.modelMapper.map(newLibrosPublicados, LibrosPublicados.class);
		
		Usuarios user = this.daoUser.findIdUsuario(newLibrosPublicados.getUsuario().getIdUsuario());
		Roles rol = this.daoRol.findIdRol(user.getRole().getIdRol());
		Libros libro = this.daoLibro.findIdLibros(newLibrosPublicados.getLibro().getIdLibros());
		EstadosLibros estado = this.dao.findIdEstadosLibros(libro.getEstadoslibro().getIdEstadosLibros());
		CategoriasLibros categoria = this.daoCategory.findIdCategoriasLibros(libro.getCategoriaslibro().getIdCategoriaLibro());
		DisponibilidadLibros disponibilidad = this.daoDisponibilidad.findIdDisponibilidadLibros(libro.getDisponibilidadlibro().getIdDisponibilidadLibro());
		
		libro.setDisponibilidadlibro(disponibilidad);
		libro.setCategoriaslibro(categoria);
		libro.setEstadoslibro(estado); 
		
		user.setRole(rol);
		addLibrosPublicados.setUsuario(user);
		addLibrosPublicados.setLibro(libro);
		
		
		LibrosPublicadosDTO addedLibrosPublicados = this.service.addLibrosPublicados(addLibrosPublicados);
		return new ResponseEntity<LibrosPublicadosDTO>( addedLibrosPublicados, HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-libro-publicado", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibrosPublicadosDTO> putLibrosPublicados(@RequestBody LibrosPublicadosDTO updateLibrosPublicados) {
		LibrosPublicados updLibrosPublicados = this.modelMapper.map(updateLibrosPublicados, LibrosPublicados.class);
		LibrosPublicadosDTO updatedLibrosPublicados = this.service.upLibrosPublicados(updLibrosPublicados);
		return new ResponseEntity<LibrosPublicadosDTO>(updatedLibrosPublicados, HttpStatus.OK);
	}
	
}
