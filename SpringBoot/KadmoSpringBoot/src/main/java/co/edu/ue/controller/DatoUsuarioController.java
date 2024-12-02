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

import co.edu.ue.dto.DatosUsuariosDTO;
import co.edu.ue.entity.DatosUsuarios;
import co.edu.ue.entity.Generos;
import co.edu.ue.entity.Roles;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.IGenerosRepository;
import co.edu.ue.repository.dao.IRolRepository;
import co.edu.ue.repository.dao.IUsuarioRepository;
import co.edu.ue.service.IDatoUsuarioService;
import co.edu.ue.utils.ApiResponse;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin("*")
@RequestMapping(value="dato-usuario")
public class DatoUsuarioController {
	
	@Autowired
	private IGenerosRepository daoGen;
	
	@Autowired
	private IRolRepository daoRol;
	
	@Autowired
	private IUsuarioRepository daoUser;
	
	@Autowired
    private ModelMapper modelMapper; 
	
	@Autowired
	IDatoUsuarioService service;
	

	@GetMapping(value="datos-usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DatosUsuariosDTO>> getAllDatosUsuarios() {
		return new ResponseEntity<List<DatosUsuariosDTO>> ( this.service.listAllDatosUsuarios(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="dato-usuario-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DatosUsuariosDTO> getByIdDatoUsuario(@RequestParam("idDatoUsuario") int id) {
		return new ResponseEntity<DatosUsuariosDTO>( this.service.findIdDatoUsuario(id), HttpStatus.ACCEPTED);
	}

	@PostMapping(value="dato-find-id-usuario", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<DatosUsuariosDTO> getDatoByIdUsuario(@RequestBody Usuarios idUsuario) {
		return new ResponseEntity<DatosUsuariosDTO>( this.service.findByIdUsuario(idUsuario), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-dato-usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<DatosUsuariosDTO>> postDatoUsuario( @Valid @RequestBody DatosUsuariosDTO newDatoUsuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		DatosUsuarios addDatoUser = modelMapper.map(newDatoUsuario, DatosUsuarios.class);
		
		Generos genero = this.daoGen.findIdGeneros(newDatoUsuario.getGenero().getIdGenero());
		Usuarios user = this.daoUser.findIdUsuario(newDatoUsuario.getUsuario().getIdUsuario());
		Roles rol = this.daoRol.findIdRol(user.getRole().getIdRol());
		
		user.setRole(rol);
		addDatoUser.setUsuario(user);
		addDatoUser.setGenero(genero);
		
		
		DatosUsuariosDTO addedDatoUser = this.service.addDatoUsuario(addDatoUser);
		return new ResponseEntity<>(new ApiResponse<>("Datos de usuario agregados correctamente",addedDatoUser) , HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-dato-usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<DatosUsuariosDTO>> putDatoUsuario(@Valid @RequestBody DatosUsuariosDTO updateDatoUsuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		DatosUsuarios updateDatoUser = modelMapper.map(updateDatoUsuario, DatosUsuarios.class);
		
		Generos genero = this.daoGen.findIdGeneros(updateDatoUsuario.getGenero().getIdGenero());
		Usuarios user = this.daoUser.findIdUsuario(updateDatoUsuario.getUsuario().getIdUsuario());
		Roles rol = this.daoRol.findIdRol(user.getRole().getIdRol());
		
		user.setRole(rol);
		updateDatoUser.setUsuario(user);
		updateDatoUser.setGenero(genero);
		
		DatosUsuariosDTO updatedDatoUser = this.service.updDatoUsuario(updateDatoUser);
		return new ResponseEntity<>(new ApiResponse<>("Datos de usuario editados correctamente",updatedDatoUser) , HttpStatus.OK);
	}
	
	
}
