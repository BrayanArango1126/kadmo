package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Roles;
import co.edu.ue.service.IRolService;
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
	IRolService service;
	
	@GetMapping(value="roles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Roles> getAllRoles() {
		return this.service.listAllRoles();
	}
	
	@GetMapping(value="id-rol", produces = MediaType.APPLICATION_JSON_VALUE)
	public Roles getByIdRol(@RequestParam("idRol") int id) {
		return this.service.findIdRol(id);
	}
	
	@PostMapping(value="add-rol", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Roles postRol(@RequestBody Roles newRol) {
		return this.service.addRol(newRol);
	}
	
	@PutMapping(value="update-rol", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Roles putRol(@RequestBody Roles updateRol) {
		return this.service.updRol(updateRol);
	}
	
	/*@PutMapping("path/{id}")
	public String putMethodName(@PathVariable String id, @RequestBody String entity) {
		//TODO: process PUT request
		
		return entity;
	}*/
	
	
	
	
	
	
}
