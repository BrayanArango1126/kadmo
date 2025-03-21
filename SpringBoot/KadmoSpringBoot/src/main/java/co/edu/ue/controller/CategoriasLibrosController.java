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

import co.edu.ue.dto.CategoriasLibrosDTO;
import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.service.ICategoriasLibrosService;
import co.edu.ue.utils.ApiResponse;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping(value="categoria-libro")
public class CategoriasLibrosController {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ICategoriasLibrosService service;
	
	@GetMapping(value="categorias-libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriasLibrosDTO>> getAllCategoriasLibros() {
		return new ResponseEntity<List<CategoriasLibrosDTO>> ( this.service.listAllCategoriasLibros(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="categoria-libro-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriasLibrosDTO> getByIdCategoriasLibros(@RequestParam("idCategoriaLibro") int id) {
		return new ResponseEntity<CategoriasLibrosDTO>( this.service.findIdCategoriasLibros(id), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="add-categoria-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<CategoriasLibrosDTO>> postCategoriasLibros(@Valid @RequestBody CategoriasLibrosDTO newCategoriasLibros, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		CategoriasLibros addCategory = this.modelMapper.map(newCategoriasLibros, CategoriasLibros.class);
		CategoriasLibrosDTO addedCategory = this.service.addCategoriasLibros(addCategory);
		return new ResponseEntity<>(new ApiResponse<>("Categoría de libros agregado correctamente",addedCategory), HttpStatus.CREATED);
	}
	
	@PutMapping(value="update-categoria-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<CategoriasLibrosDTO>>  putCategoriasLibros(@Valid @RequestBody CategoriasLibrosDTO updateCategoriasLibros, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(bindingResult.getFieldError().getDefaultMessage(), null ) ,HttpStatus.CONFLICT);
		}
		CategoriasLibros updateCategory = this.modelMapper.map(updateCategoriasLibros, CategoriasLibros.class);
		CategoriasLibrosDTO updatedCategory = this.service.upCategoriasLibros(updateCategory);
		return new ResponseEntity<>(new ApiResponse<>("Categoría de libros editado correctamente",updatedCategory), HttpStatus.OK);
	}
	
}
