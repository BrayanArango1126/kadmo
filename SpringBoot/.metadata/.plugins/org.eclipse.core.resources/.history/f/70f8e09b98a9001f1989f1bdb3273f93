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
import co.edu.ue.dto.GenerosDTO;
import co.edu.ue.entity.Generos;
import co.edu.ue.service.IGenerosService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping(value="genero")

public class GenerosController {
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	IGenerosService service;
	
	@GetMapping(value="generos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GenerosDTO>> getAllGeneros() {
		return new ResponseEntity<List<GenerosDTO>> ( this.service.listAllGeneros(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="cgenero-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenerosDTO> getByIdGeneros(@RequestParam("idGenero") int id) {
		return new ResponseEntity<GenerosDTO>(this.service.findIdGeneros(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-genero", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<GenerosDTO>> postGeneros(@Valid @RequestBody GenerosDTO newGeneros, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		Generos addNewGenero = modelMapper.map(newGeneros, Generos.class);
		GenerosDTO addedNewGenero = this.service.addGeneros(addNewGenero);
		return new ResponseEntity<>(new ApiResponse<>("Genero agregado correctamente",addedNewGenero) , HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-genero", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<GenerosDTO>> putGeneros(@Valid @RequestBody GenerosDTO updateGeneros, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		Generos updateNewGenero = modelMapper.map(updateGeneros, Generos.class);
		GenerosDTO updatedNewGenero = this.service.addGeneros(updateNewGenero);
		return new ResponseEntity<>(new ApiResponse<>("Genero agregado correctamente",updatedNewGenero), HttpStatus.OK);
	}
}
