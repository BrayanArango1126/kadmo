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

import co.edu.ue.dto.DisponibilidadLibrosDTO;
import co.edu.ue.entity.DisponibilidadLibros;
import co.edu.ue.service.IDisponibilidadLibrosService;
import co.edu.ue.utils.ApiResponse;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping(value="disponibilidad-libro")
public class DisponibilidadLibroController {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IDisponibilidadLibrosService service;
	
	@GetMapping(value="disponibilidad-libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DisponibilidadLibrosDTO>> getAllDisponibilidadLibros() {
		return new ResponseEntity<List<DisponibilidadLibrosDTO>> ( this.service.listAllDisponibilidadLibros(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="disponibilidad-libro-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DisponibilidadLibrosDTO> getByIdDisponibilidadLibros(@RequestParam("idDisponibilidadLibro") int id) {
		return new ResponseEntity<DisponibilidadLibrosDTO>( this.service.findIdDisponibilidadLibros(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-disponibilidad-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<DisponibilidadLibrosDTO>> postDisponibilidadLibros(@Valid @RequestBody DisponibilidadLibrosDTO newDisponibilidadLibros, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		
		DisponibilidadLibros addDisponibilidad = this.modelMapper.map(newDisponibilidadLibros, DisponibilidadLibros.class);
		DisponibilidadLibrosDTO addedDisponibilidad = this.service.addDisponibilidadLibros(addDisponibilidad);
		return new ResponseEntity<>(new ApiResponse<>("Disponibilidad de libros agregado correctamente",addedDisponibilidad), HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-disponibilidad-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<DisponibilidadLibrosDTO>> putDisponibilidadLibros(@Valid @RequestBody DisponibilidadLibrosDTO updateDisponibilidadLibros, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		
		DisponibilidadLibros updDisponibilidad = this.modelMapper.map(updateDisponibilidadLibros, DisponibilidadLibros.class);
		DisponibilidadLibrosDTO updatedDisponibilidad = this.service.upDisponibilidadLibros(updDisponibilidad);
		return new ResponseEntity<>(new ApiResponse<>("Disponibilidad de libros editado correctamente",updatedDisponibilidad), HttpStatus.OK);
	}
}
