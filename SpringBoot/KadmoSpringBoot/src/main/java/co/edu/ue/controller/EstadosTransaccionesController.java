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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.ue.dto.EstadosTransaccionesDTO;
import co.edu.ue.entity.EstadosTransacciones;
import co.edu.ue.service.IEstadosTransaccionesService;
import co.edu.ue.utils.ApiResponse;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping(value="estado-transaccion")

public class EstadosTransaccionesController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	IEstadosTransaccionesService service;

	@GetMapping(value="estados-transacciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadosTransaccionesDTO>> getAllEstadosTransacciones() {
		return new ResponseEntity<List<EstadosTransaccionesDTO>> ( this.service.listAllEstadosTransacciones(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="estado-transaccion-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstadosTransaccionesDTO> getByIdEstadosTransacciones(@RequestParam("idEstadoTransaccion") int id) {
		return new ResponseEntity<EstadosTransaccionesDTO>( this.service.findIdEstadosTransacciones(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-estado-transaccion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<EstadosTransaccionesDTO>> postEstadosTransacciones(@Valid @RequestBody EstadosTransaccionesDTO newEstadosTransacciones, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		
		EstadosTransacciones addEstadoTransac = this.modelMapper.map(newEstadosTransacciones, EstadosTransacciones.class);
		EstadosTransaccionesDTO addedEstadoTransac = this.service.addEstadosTransacciones(addEstadoTransac);
		return new ResponseEntity<>(new ApiResponse<>("Estado de transacción agregado correctamente",addedEstadoTransac) , HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-estado-transaccion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<EstadosTransaccionesDTO>> putEstadosTransacciones(@Valid @RequestBody EstadosTransaccionesDTO updateEstadosTransacciones, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		EstadosTransacciones upEstadoTransac = this.modelMapper.map(updateEstadosTransacciones, EstadosTransacciones.class);
		EstadosTransaccionesDTO updatedEstadoTransac = this.service.upEstadosTransacciones(upEstadoTransac);
		return new ResponseEntity<>(new ApiResponse<>("Estado de transacción editado correctamente",updatedEstadoTransac) , HttpStatus.OK);
	}
}
