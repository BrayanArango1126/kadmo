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

import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.service.ICategoriasLibrosService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="categoria-libro")
public class CategoriasLibrosController {

	@Autowired
	ICategoriasLibrosService service;
	
	@GetMapping(value="categorias-libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriasLibros>> getAllCategoriasLibros() {
		return new ResponseEntity<List<CategoriasLibros>> ( this.service.listAllCategoriasLibros(), HttpStatus.OK);
	}
	
	@GetMapping(value="categoria-libro-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public CategoriasLibros getByIdCategoriasLibros(@RequestParam("idCategoriaLibro") int id) {
		return this.service.findIdCategoriasLibros(id);
	}
	
	@PostMapping(value="add-categoria-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoriasLibros postCategoriasLibros(@RequestBody CategoriasLibros newCategoriasLibros) {
		return this.service.addCategoriasLibros(newCategoriasLibros);
	}
	
	@PutMapping(value="update-categoria-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoriasLibros putCategoriasLibros(@RequestBody CategoriasLibros updateCategoriasLibros) {
		return this.service.upCategoriasLibros(updateCategoriasLibros);
	}
	
}
