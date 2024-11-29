package co.edu.ue.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.dto.LibrosDTO;
import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.entity.DisponibilidadLibros;
import co.edu.ue.entity.EstadosLibros;
import co.edu.ue.entity.Libros;
import co.edu.ue.repository.dao.ICategoriaLibrosRepository;
import co.edu.ue.repository.dao.IDisponibilidadLibrosRepository;
import co.edu.ue.repository.dao.IEstadosLibrosRepository;
import co.edu.ue.service.ILibrosService;
import co.edu.ue.utils.ApiResponse;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "libro")
public class LibrosController {

	@Autowired
	private IEstadosLibrosRepository dao;

	@Autowired
	private IDisponibilidadLibrosRepository daoDisponibilidad;

	@Autowired
	private ICategoriaLibrosRepository daoCategory;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ILibrosService service;

	@GetMapping(value = "libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LibrosDTO>> getAllLibros() {
		return new ResponseEntity<List<LibrosDTO>>(this.service.listAllLibros(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "libro-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibrosDTO> getByIdLibros(@RequestParam("idLibros") int id) {
		return new ResponseEntity<LibrosDTO>(this.service.findIdLibros(id), HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "add-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<LibrosDTO>> postLibros(@Valid @RequestBody LibrosDTO newLibros,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null),
					HttpStatus.CONFLICT);
		}
		Libros addLibros = this.modelMapper.map(newLibros, Libros.class);

		EstadosLibros estado = this.dao.findIdEstadosLibros(newLibros.getEstadosLibro().getIdEstadosLibros());
		CategoriasLibros categoria = this.daoCategory
				.findIdCategoriasLibros(newLibros.getCategoriasLibro().getIdCategoriaLibro());
		DisponibilidadLibros disponibilidad = this.daoDisponibilidad
				.findIdDisponibilidadLibros(newLibros.getDisponibilidadLibro().getIdDisponibilidadLibro());

		addLibros.setDisponibilidadlibro(disponibilidad);
		addLibros.setCategoriaslibro(categoria);
		addLibros.setEstadoslibro(estado);
		LibrosDTO addedLibros = this.service.addLibros(addLibros);
		return new ResponseEntity<>(new ApiResponse<>("Libro agregado correctamente", addedLibros), HttpStatus.CREATED);
	}

	@PutMapping(value = "update-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<LibrosDTO>> putLibros(@Valid @RequestBody LibrosDTO updateLibros,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null),
					HttpStatus.CONFLICT);
		}
		Libros updLibros = this.modelMapper.map(updateLibros, Libros.class);
		LibrosDTO updatedLibros = this.service.addLibros(updLibros);
		return new ResponseEntity<>(new ApiResponse<>("Libro editado correctamente", updatedLibros), HttpStatus.OK);
	}
}
