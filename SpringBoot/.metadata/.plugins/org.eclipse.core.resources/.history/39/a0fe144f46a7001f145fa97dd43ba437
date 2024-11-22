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

import co.edu.ue.entity.Transacciones;
import co.edu.ue.service.ITransaccionesService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="transaccion")

public class TransaccionesController {

	@Autowired
	ITransaccionesService service;
	
	@GetMapping(value="transacciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transacciones>> getAllTransacciones() {
		return new ResponseEntity<List<Transacciones>> ( this.service.listAllTransacciones(), HttpStatus.OK);
	}
	
	@GetMapping(value="transaccion-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public Transacciones getByIdTransacciones(@RequestParam("idTransaccion") int id) {
		return this.service.findIdTransacciones(id);
	}
	
	@PostMapping(value="add-transaccion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Transacciones postTransacciones(@RequestBody Transacciones newTransacciones) {
		return this.service.addTransacciones(newTransacciones);
	}
	
	@PutMapping(value="update-transaccion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Transacciones putTransacciones(@RequestBody Transacciones updateTransacciones) {
		return this.service.upTransacciones(updateTransacciones);
	}
}
