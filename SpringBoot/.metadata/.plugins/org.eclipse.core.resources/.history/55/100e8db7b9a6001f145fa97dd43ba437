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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.EstadosTransacciones;
import co.edu.ue.service.IEstadosTransaccionesService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping(value="estado-transaccion")

public class EstadosTransaccionesController {
	
	@Autowired
	IEstadosTransaccionesService service;

	@GetMapping(value="estados-transacciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstadosTransacciones>> getAllEstadosTransacciones() {
		return new ResponseEntity<List<EstadosTransacciones>> ( this.service.listAllEstadosTransacciones(), HttpStatus.OK);
	}
	
	@GetMapping(value="estado-transaccion-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public EstadosTransacciones getByIdEstadosTransacciones(@RequestParam("idEstadoTransaccion") int id) {
		return this.service.findIdEstadosTransacciones(id);
	}
	
	@PostMapping(value="add-estado-transaccion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EstadosTransacciones postEstadosTransacciones(@RequestBody EstadosTransacciones newEstadosTransacciones) {
		return this.service.addEstadosTransacciones(newEstadosTransacciones);
	}
	
	@PutMapping(value="update-estado-transaccion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EstadosTransacciones putEstadosTransacciones(@RequestBody EstadosTransacciones updateEstadosTransacciones) {
		return this.service.upEstadosTransacciones(updateEstadosTransacciones);
	}
}
