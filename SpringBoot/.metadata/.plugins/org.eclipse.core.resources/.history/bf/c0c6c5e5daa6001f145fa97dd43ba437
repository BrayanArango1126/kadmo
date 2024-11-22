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

import co.edu.ue.entity.Calificaciones;
import co.edu.ue.service.ICalificacionesService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="calificacion")
public class CalificacionesController {
	
	@Autowired
	ICalificacionesService service;
	
	@GetMapping(value="calificaciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Calificaciones>> getAllCalificaciones() {
		return new ResponseEntity<List<Calificaciones>> ( this.service.listAllCalificaciones(), HttpStatus.OK);
	}
	
	@GetMapping(value="calificacion-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public Calificaciones getByIdCalificaciones(@RequestParam("idCalificacion") int id) {
		return this.service.findIdCalificaciones(id);
	}
	
	@PostMapping(value="add-calificacion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Calificaciones postCategoriasLibros(@RequestBody Calificaciones newCalificaciones) {
		return this.service.addCalificaciones(newCalificaciones);
	}
	
	@PutMapping(value="update-calificacion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Calificaciones putCalificaciones(@RequestBody Calificaciones updateCalificaciones) {
		return this.service.upCalificaciones(updateCalificaciones);
	}

}
