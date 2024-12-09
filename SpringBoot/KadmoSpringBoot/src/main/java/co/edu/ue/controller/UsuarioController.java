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

import co.edu.ue.dto.UsuariosDTO;
import co.edu.ue.entity.Roles;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.IRolRepository;
import co.edu.ue.service.IUsuarioService;
import co.edu.ue.utils.ApiResponse;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("*")
@RequestMapping(value="usuario")
public class UsuarioController{
	
	@Autowired
	private IRolRepository dao;
	
	@Autowired
    private ModelMapper modelMapper; 

	@Autowired
	IUsuarioService service;
	
	@GetMapping(value="usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuariosDTO>> getAllUsuarios() {
		return new ResponseEntity<List<UsuariosDTO>> (this.service.listAllUsuarios(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="usuario-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuariosDTO>  getByIdUsario(@RequestParam("idUsuario") int id) {
		return new ResponseEntity<UsuariosDTO>( this.service.findIdUsuario(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<UsuariosDTO>> postUsuario(@Valid @RequestBody UsuariosDTO newUsuario, BindingResult bindingResult) {
		System.out.println("Usuario: "+newUsuario);
		if(bindingResult.hasErrors()) {
			System.out.println("Usuario: "+newUsuario);
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		System.out.println("Usuario: "+newUsuario);
		Usuarios addUser = modelMapper.map(newUsuario, Usuarios.class);
		Roles rol = this.dao.findIdRol(newUsuario.getRol().getIdRol());
		addUser.setRole(rol);
		
		UsuariosDTO addedUser = this.service.addUsuario(addUser);
		return new ResponseEntity<>(new ApiResponse<>("Usuario agregado correctamente",addedUser), HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<UsuariosDTO>> putUsuario(@Valid @RequestBody UsuariosDTO updateUsuario, BindingResult bindingResult) {
		Usuarios updateUser = modelMapper.map(updateUsuario, Usuarios.class);
		
		Roles rol = this.dao.findIdRol(updateUsuario.getRol().getIdRol());
		updateUser.setRole(rol);
		
		UsuariosDTO updatedUser = this.service.addUsuario(updateUser);
		return new ResponseEntity<>(new ApiResponse<>("Usuario editado correctamente",updatedUser), HttpStatus.OK);
	}
	
	
	
}
