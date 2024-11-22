package co.edu.ue.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import co.edu.ue.dto.MembresiasDTO;
import co.edu.ue.entity.Membresias;
import co.edu.ue.entity.Roles;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.IRolRepository;
import co.edu.ue.repository.dao.IUsuarioRepository;
import co.edu.ue.service.IMembresiasService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="membresia")

public class MembresiasController {
	
	@Autowired
	private IRolRepository daoRol;
	
	@Autowired
	private IUsuarioRepository daoUser;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IMembresiasService service;
	
	@GetMapping(value="membresias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MembresiasDTO>> getAllMembresias() {
		return new ResponseEntity<List<MembresiasDTO>> ( this.service.listAllMembresias(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="membresia-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MembresiasDTO> getByIdMembresias(@RequestParam("idMembresia") int id) {
		return new ResponseEntity<MembresiasDTO>( this.service.findIdMembresias(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-membresia", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MembresiasDTO> postMembresias(@RequestBody MembresiasDTO newMembresias) {
		Membresias addMembresia = this.modelMapper.map(newMembresias, Membresias.class);
		
		Usuarios user = this.daoUser.findIdUsuario(newMembresias.getUsuario().getIdUsuario());
		Roles rol = this.daoRol.findIdRol(user.getRole().getIdRol());
		
		user.setRole(rol);
		addMembresia.setUsuario(user);
		MembresiasDTO addedMembresia = this.service.addMembresias(addMembresia);
		return new ResponseEntity<MembresiasDTO>(addedMembresia, HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-membresia", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MembresiasDTO> putMembresias(@RequestBody MembresiasDTO updateMembresias) {
		Membresias updMembresias = this.modelMapper.map(updateMembresias, Membresias.class);
		MembresiasDTO updatedMembresias = this.service.upMembresias(updMembresias);
		return new ResponseEntity<MembresiasDTO>(updatedMembresias, HttpStatus.OK);
	}
}
