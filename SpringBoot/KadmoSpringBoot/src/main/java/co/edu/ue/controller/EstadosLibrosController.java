package co.edu.ue.controller;

import java.util.List;

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

import co.edu.ue.entity.EstadosLibros;
import co.edu.ue.service.IEstadosLibrosService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="estados-libro")
public class EstadosLibrosController {

	@Autowired
	IEstadosLibrosService service;
	
	@GetMapping(value="estados-libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadosLibros>> getAllEstadosLibros() {
		return new ResponseEntity<List<EstadosLibros>> ( this.service.listAllEstadosLibros(), HttpStatus.OK);
	}
	
	@GetMapping(value="estado-libro-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public EstadosLibros getByIdEstadosLibros(@RequestParam("idEstadoLibro") int id) {
		return this.service.findIdEstadosLibros(id);
	}
	
	@PostMapping(value="add-estado-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EstadosLibros postEstadosLibros(@RequestBody EstadosLibros newEstadosLibros) {
		return this.service.addEstadosLibros(newEstadosLibros);
	}
	
	@PutMapping(value="update-estado-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EstadosLibros putEstadosLibros(@RequestBody EstadosLibros updateEstadosLibros) {
		return this.service.upEstadosLibros(updateEstadosLibros);
	}
}
