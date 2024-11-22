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

import co.edu.ue.entity.ImagenesLibros;
import co.edu.ue.service.IImagenesLibrosService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="imagen-libro")
public class ImagenesLibrosController {

	@Autowired
	IImagenesLibrosService service;
	
	@GetMapping(value="imagenes-libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ImagenesLibros>> getAllImagenesLibros() {
		return new ResponseEntity<List<ImagenesLibros>> ( this.service.listAllImagenesLibros(), HttpStatus.OK);
	}
	
	@GetMapping(value="imagen-libro-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ImagenesLibros getByIdImagenesLibros(@RequestParam("idImagenLibro") int id) {
		return this.service.findIdImagenesLibros(id);
	}
	
	@PostMapping(value="add-imagen-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ImagenesLibros postImagenesLibros(@RequestBody ImagenesLibros newImagenesLibros) {
		return this.service.addImagenesLibros(newImagenesLibros);
	}
	
	@PutMapping(value="update-imagen-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ImagenesLibros putImagenesLibros(@RequestBody ImagenesLibros updateImagenesLibros) {
		return this.service.upImagenesLibros(updateImagenesLibros);
	}
}
