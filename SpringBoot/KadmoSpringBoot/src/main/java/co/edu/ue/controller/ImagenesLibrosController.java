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

import co.edu.ue.dto.ImagenesLibrosDTO;
import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.entity.DisponibilidadLibros;
import co.edu.ue.entity.EstadosLibros;
import co.edu.ue.entity.ImagenesLibros;
import co.edu.ue.entity.Libros;
import co.edu.ue.repository.dao.ICategoriaLibrosRepository;
import co.edu.ue.repository.dao.IDisponibilidadLibrosRepository;
import co.edu.ue.repository.dao.IEstadosLibrosRepository;
import co.edu.ue.repository.dao.ILibrosRepository;
import co.edu.ue.service.IImagenesLibrosService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="imagen-libro")
public class ImagenesLibrosController {
	
	@Autowired
	private IEstadosLibrosRepository dao;
	
	@Autowired	
	private IDisponibilidadLibrosRepository daoDisponibilidad;
	
	@Autowired
	private ICategoriaLibrosRepository daoCategory;
	
	@Autowired
	private ILibrosRepository daoLibro;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IImagenesLibrosService service;
	
	@GetMapping(value="imagenes-libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ImagenesLibrosDTO>> getAllImagenesLibros() {
		return new ResponseEntity<List<ImagenesLibrosDTO>> ( this.service.listAllImagenesLibros(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="imagen-libro-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImagenesLibrosDTO> getByIdImagenesLibros(@RequestParam("idImagenLibro") int id) {
		return new ResponseEntity<ImagenesLibrosDTO> (this.service.findIdImagenesLibros(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-imagen-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImagenesLibrosDTO> postImagenesLibros(@RequestBody ImagenesLibrosDTO newImagenesLibros) {
		ImagenesLibros addImagen = this.modelMapper.map(newImagenesLibros, ImagenesLibros.class);
		
		Libros libro= this.daoLibro.findIdLibros(newImagenesLibros.getLibro().getIdLibros());
		EstadosLibros estado = this.dao.findIdEstadosLibros(libro.getEstadoslibro().getIdEstadosLibros());
		CategoriasLibros categoria = this.daoCategory.findIdCategoriasLibros(libro.getCategoriaslibro().getIdCategoriaLibro());
		DisponibilidadLibros disponibilidad = this.daoDisponibilidad.findIdDisponibilidadLibros(libro.getDisponibilidadlibro().getIdDisponibilidadLibro());
		
		libro.setDisponibilidadlibro(disponibilidad);
		libro.setCategoriaslibro(categoria);
		libro.setEstadoslibro(estado); 
		
		addImagen.setLibro(libro);
		
		ImagenesLibrosDTO addedImagen = this.service.addImagenesLibros(addImagen);
		return new ResponseEntity<ImagenesLibrosDTO>( addedImagen, HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-imagen-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImagenesLibrosDTO> putImagenesLibros(@RequestBody ImagenesLibrosDTO updateImagenesLibros) {
		ImagenesLibros updImagen = this.modelMapper.map(updateImagenesLibros, ImagenesLibros.class);
		ImagenesLibrosDTO updatedImagen = this.service.upImagenesLibros(updImagen);
		return  new ResponseEntity<ImagenesLibrosDTO>(updatedImagen, HttpStatus.OK);
	}
}
