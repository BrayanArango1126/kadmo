package co.edu.ue.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;

import co.edu.ue.dto.DatosUsuariosDTO;
import co.edu.ue.dto.ImagenesLibrosDTO;
import co.edu.ue.dto.LibrosDTO;
import co.edu.ue.dto.UsuariosDTO;
import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.entity.DisponibilidadLibros;
import co.edu.ue.entity.EstadosLibros;
import co.edu.ue.entity.ImagenesLibros;
import co.edu.ue.entity.Libros;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.ICategoriaLibrosRepository;
import co.edu.ue.repository.dao.IDisponibilidadLibrosRepository;
import co.edu.ue.repository.dao.IEstadosLibrosRepository;
import co.edu.ue.repository.dao.ILibrosRepository;
import co.edu.ue.service.IImagenesLibrosService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "imagen-libro")
public class ImagenesLibrosController {

	@Autowired
	private IEstadosLibrosRepository dao;

	@Autowired
	private IDisponibilidadLibrosRepository daoDisponibilidad;

	@Autowired
	private ICategoriaLibrosRepository daoCategory;

	@Autowired
	private ILibrosRepository daoLibro;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IImagenesLibrosService service;

	@GetMapping(value = "imagenes-libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ImagenesLibrosDTO>> getAllImagenesLibros() {
		return new ResponseEntity<List<ImagenesLibrosDTO>>(this.service.listAllImagenesLibros(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "imagen-libro-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImagenesLibrosDTO> getByIdImagenesLibros(@RequestParam("idImagenLibro") int id) {
		return new ResponseEntity<ImagenesLibrosDTO>(this.service.findIdImagenesLibros(id), HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "imagen-by-id-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImagenesLibrosDTO> getImagenByIdLibro(@RequestBody LibrosDTO libro) {
		Libros libroGot = this.modelMapper.map(libro, Libros.class);
		ImagenesLibrosDTO imagenLibro = this.service.findByLibro(libroGot);
		if (imagenLibro == null) {
			return new ResponseEntity<ImagenesLibrosDTO>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<ImagenesLibrosDTO>(imagenLibro, HttpStatus.OK);
	}

	@PostMapping(value = "add-imagen-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ImagenesLibrosDTO> postImagenesLibros(@RequestParam("file") MultipartFile file,
			@RequestParam("idLibro") int idLibro) {

		try {
			String uploadDir = "src/main/resources/static/libros/";
			File uploadPath = new File(uploadDir);
			if (!uploadPath.exists()) {
				uploadPath.mkdirs();
			}

			// Crear nombre único para la imagen
			String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
			Path filePath = Paths.get(uploadDir + fileName);

			// Guardar el archivo en el servidor
			Files.write(filePath, file.getBytes());

			// Crear la URL relativa de la imagen
			String imageUrl = "/libros/" + fileName;

			ImagenesLibros imagenNew = new ImagenesLibros();
			imagenNew.setUrl(imageUrl);

			Libros libro = this.daoLibro.findIdLibros(idLibro);
			EstadosLibros estado = this.dao.findIdEstadosLibros(libro.getEstadoslibro().getIdEstadosLibros());
			CategoriasLibros categoria = this.daoCategory
					.findIdCategoriasLibros(libro.getCategoriaslibro().getIdCategoriaLibro());
			DisponibilidadLibros disponibilidad = this.daoDisponibilidad
					.findIdDisponibilidadLibros(libro.getDisponibilidadlibro().getIdDisponibilidadLibro());

			libro.setDisponibilidadlibro(disponibilidad);
			libro.setCategoriaslibro(categoria);
			libro.setEstadoslibro(estado);

			imagenNew.setLibro(libro);

			ImagenesLibrosDTO addedImagen = this.service.addImagenesLibros(imagenNew);
			return new ResponseEntity<ImagenesLibrosDTO>(addedImagen, HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<ImagenesLibrosDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "update-imagen-libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImagenesLibrosDTO> putImagenesLibros(@RequestBody ImagenesLibrosDTO updateImagenesLibros) {
		ImagenesLibros updImagen = this.modelMapper.map(updateImagenesLibros, ImagenesLibros.class);
		ImagenesLibrosDTO updatedImagen = this.service.upImagenesLibros(updImagen);
		return new ResponseEntity<ImagenesLibrosDTO>(updatedImagen, HttpStatus.OK);
	}
}
