package co.edu.ue.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.dto.RolDTO;
import co.edu.ue.entity.Roles;
import co.edu.ue.service.IRolService;
import co.edu.ue.utils.ApiResponse;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin("*")
@RequestMapping(value="rol")
public class RolController {
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	IRolService service;
	
	@GetMapping(value="roles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RolDTO>>  getAllRoles() {
		return new ResponseEntity<List<RolDTO>>( this.service.listAllRoles(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="id-rol", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolDTO>  getByIdRol(@RequestParam("idRol") int id) {
		return new ResponseEntity<RolDTO>( this.service.findIdRol(id), HttpStatus.ACCEPTED);
	}
	
	/*@PostMapping(value="add-rol", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> postRol(@Valid @RequestBody Roles newRol, BindingResult bindingResult) {
		//return new ResponseEntity<String>(""this.service.addRol(newRol));
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.CONFLICT);
		}
		int sizeListBefore = service.listAllRoles().size();
		service.addRol(newRol);
		int sizeListAfter = service.listAllRoles().size();
		if(sizeListAfter > sizeListBefore) {
			return new ResponseEntity<String> ("El rol fue añadido correctamente", HttpStatus.OK);			
		}
		return new ResponseEntity<String>("Hubo un problema externo", HttpStatus.CONFLICT);
	}*/
	
	/*
	 @PostMapping(value="add-rol", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RolDTO> postRol(@Valid @RequestBody RolDTO newRolDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<String>(bindingResult.getFieldError().getDefaultMessage(),HttpStatus.CONFLICT);
		}
		Roles addNewRol = modelMapper.map(newRolDTO, Roles.class);
		RolDTO addedNewRol = this.service.addRol(addNewRol);
		return new ResponseEntity<RolDTO>(addedNewRol, HttpStatus.CREATED); 
	}
	 * */
	
	@PostMapping(value="add-rol", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<RolDTO>> postRol(@Valid @RequestBody RolDTO newRolDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		Roles addNewRol = modelMapper.map(newRolDTO, Roles.class);
		RolDTO addedNewRol = this.service.addRol(addNewRol);
		return new ResponseEntity<>(new ApiResponse<>("Rol agregado correctamente",addedNewRol), HttpStatus.CREATED); 
	}
	
	@PutMapping(value="update-rol", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<RolDTO>> putRol(@Valid @RequestBody RolDTO updateRol, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		Roles updateNewRol = modelMapper.map(updateRol, Roles.class);
		RolDTO updatedRol = this.service.updRol(updateNewRol);
		return new ResponseEntity<>(new ApiResponse<>("Rol actualizado correctamente",updatedRol), HttpStatus.OK);
	}	
}
