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

import co.edu.co.utils.ApiResponse;
import co.edu.ue.dto.EstadosLibrosDTO;
import co.edu.ue.entity.EstadosLibros;
import co.edu.ue.service.IEstadosLibrosService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping(value="estados-libro")
public class EstadosLibrosController {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IEstadosLibrosService service;
	
	@GetMapping(value="estados-libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadosLibrosDTO>> getAllEstadosLibros() {
		return new ResponseEntity<List<EstadosLibrosDTO>> ( this.service.listAllEstadosLibros(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="estado-libro-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstadosLibrosDTO> getByIdEstadosLibros(@RequestParam("idEstadosLibros") int id) {
		return new ResponseEntity<EstadosLibrosDTO>( this.service.findIdEstadosLibros(id),HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-estado-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<ApiResponse<EstadosLibrosDTO>> postEstadosLibros(@Valid @RequestBody EstadosLibrosDTO newEstadosLibros, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		EstadosLibros addEstadoLibro = this.modelMapper.map(newEstadosLibros, EstadosLibros.class);
		EstadosLibrosDTO addedEstadoLibro = this.service.addEstadosLibros(addEstadoLibro);
		return new ResponseEntity<>(new ApiResponse<>("Estado de libros agregado correctamente",addedEstadoLibro) ,HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-estado-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<ApiResponse<EstadosLibrosDTO> > putEstadosLibros(@Valid @RequestBody EstadosLibrosDTO updateEstadosLibros, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		EstadosLibros udtEstadoLibro = this.modelMapper.map(updateEstadosLibros, EstadosLibros.class);
		EstadosLibrosDTO updatedEstadoLibro = this.service.upEstadosLibros(udtEstadoLibro);
		return new ResponseEntity<>(new ApiResponse<>("Estado de libros editado correctamente",updatedEstadoLibro) ,HttpStatus.OK);
	}
}
