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

import co.edu.ue.dto.CalificacionesDTO;
import co.edu.ue.entity.Calificaciones;
import co.edu.ue.entity.Libros;
import co.edu.ue.service.ICalificacionesService;
import co.edu.ue.utils.ApiResponse;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping(value="calificacion")
public class CalificacionesController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	ICalificacionesService service;
	
	@GetMapping(value="calificaciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalificacionesDTO>> getAllCalificaciones() {
		return new ResponseEntity<List<CalificacionesDTO>> ( this.service.listAllCalificaciones(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="calificacion-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalificacionesDTO> getByIdCalificaciones(@RequestParam("idCalificacion") int id) {
		return new ResponseEntity<CalificacionesDTO>( this.service.findIdCalificaciones(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="calificaciones-libro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalificacionesDTO>> getCalificacionByLibroId(@RequestBody Libros idLibro) {
		return new ResponseEntity<List<CalificacionesDTO>>( this.service.findByIdLibro(idLibro), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-calificacion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<CalificacionesDTO>> postCategoriasLibros(@Valid @RequestBody CalificacionesDTO newCalificaciones, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		Calificaciones addCalificacion = this.modelMapper.map(newCalificaciones, Calificaciones.class);
		CalificacionesDTO addedCalificacion = this.service.addCalificaciones(addCalificacion);
		return new ResponseEntity<>(new ApiResponse<>("Puntuación registrada correctamente",addedCalificacion) , HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-calificacion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<CalificacionesDTO>> putCalificaciones(@Valid @RequestBody CalificacionesDTO updateCalificaciones, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		Calificaciones upCalificacion = this.modelMapper.map(updateCalificaciones, Calificaciones.class);
		CalificacionesDTO updatedCalificacion = this.service.upCalificaciones(upCalificacion);
		return new ResponseEntity<>(new ApiResponse<>("Puntuación editada correctamente",updatedCalificacion) , HttpStatus.OK);
	}

}
