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

import co.edu.ue.entity.Libros;
import co.edu.ue.service.ILibrosService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="libro")
public class LibrosController {

	@Autowired
	ILibrosService service;
	
	@GetMapping(value="libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libros>> getAllLibros() {
		return new ResponseEntity<List<Libros>> ( this.service.listAllLibros(), HttpStatus.OK);
	}
	
	@GetMapping(value="libro-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public Libros getByIdLibros(@RequestParam("idLibro") int id) {
		return this.service.findIdLibros(id);
	}
	
	@PostMapping(value="add-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Libros postLibros(@RequestBody Libros newLibros) {
		return this.service.addLibros(newLibros);
	}
	
	@PutMapping(value="update-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Libros putLibros(@RequestBody Libros updateLibros) {
		return this.service.upLibros(updateLibros);
	}
}
