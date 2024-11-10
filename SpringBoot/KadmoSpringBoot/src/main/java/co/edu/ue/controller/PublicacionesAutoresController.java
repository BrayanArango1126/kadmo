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

import co.edu.ue.entity.PublicacionesAutores;
import co.edu.ue.service.IPublicacionesAutoresService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="publicacion-autor")

public class PublicacionesAutoresController {

	@Autowired
	IPublicacionesAutoresService service;
	
	@GetMapping(value="publicaciones-autores", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PublicacionesAutores>> getAllPublicacionesAutores() {
		return new ResponseEntity<List<PublicacionesAutores>> ( this.service.listAllPublicacionesAutores(), HttpStatus.OK);
	}
	
	@GetMapping(value="publicacion-autor-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public PublicacionesAutores getByIdPublicacionesAutores(@RequestParam("idPublicacionAutor") int id) {
		return this.service.findIdPublicacionesAutores(id);
	}
	
	@PostMapping(value="add-publicacion-autor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PublicacionesAutores postPublicacionesAutores(@RequestBody PublicacionesAutores newPublicacionesAutores) {
		return this.service.addPublicacionesAutores(newPublicacionesAutores);
	}
	
	@PutMapping(value="update-publicacion-autor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PublicacionesAutores putPublicacionesAutores(@RequestBody PublicacionesAutores updatePublicacionesAutores) {
		return this.service.upPublicacionesAutores(updatePublicacionesAutores);
	}
}
