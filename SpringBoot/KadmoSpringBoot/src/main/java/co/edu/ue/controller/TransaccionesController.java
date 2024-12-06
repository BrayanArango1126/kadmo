package co.edu.ue.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
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

import co.edu.ue.dto.TransaccionesDTO;
import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.entity.DisponibilidadLibros;
import co.edu.ue.entity.EstadosLibros;
import co.edu.ue.entity.EstadosTransacciones;
import co.edu.ue.entity.Libros;
import co.edu.ue.entity.Roles;
import co.edu.ue.entity.Transacciones;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.ICategoriaLibrosRepository;
import co.edu.ue.repository.dao.IDisponibilidadLibrosRepository;
import co.edu.ue.repository.dao.IEstadosLibrosRepository;
import co.edu.ue.repository.dao.IEstadosTransaccionesRepository;
import co.edu.ue.repository.dao.ILibrosRepository;
import co.edu.ue.repository.dao.IRolRepository;
import co.edu.ue.repository.dao.IUsuarioRepository;
import co.edu.ue.service.ITransaccionesService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "transaccion")

public class TransaccionesController {

	@Autowired
	private IEstadosLibrosRepository dao;

	@Autowired
	private IDisponibilidadLibrosRepository daoDisponibilidad;

	@Autowired
	private ICategoriaLibrosRepository daoCategory;

	@Autowired
	private IRolRepository daoRol;

	@Autowired
	private IUsuarioRepository daoUser;

	@Autowired
	private ILibrosRepository daoLibro;

	@Autowired
	private IEstadosTransaccionesRepository daoTransa;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ITransaccionesService service;

	@GetMapping(value = "transacciones", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransaccionesDTO>> getAllTransacciones() {
		return new ResponseEntity<List<TransaccionesDTO>>(this.service.listAllTransacciones(), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "transaccion-id", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransaccionesDTO> getByIdTransacciones(@RequestParam("idTransaccion") int id) {
		return new ResponseEntity<TransaccionesDTO>(this.service.findIdTransacciones(id), HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "add-transaccion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransaccionesDTO> postTransacciones(@RequestBody TransaccionesDTO newTransacciones) {
		Transacciones addTransaccion = this.modelMapper.map(newTransacciones, Transacciones.class);

		EstadosTransacciones transa = this.daoTransa
				.findIdEstadosTransacciones(newTransacciones.getEstadosTransaccione().getIdEstadoTransaccion());
		Usuarios user = this.daoUser.findIdUsuario(newTransacciones.getUsuario().getIdUsuario());
		Roles rol = this.daoRol.findIdRol(user.getRole().getIdRol());
		Libros libro = this.daoLibro.findIdLibros(newTransacciones.getLibro().getIdLibros());
		EstadosLibros estado = this.dao.findIdEstadosLibros(libro.getEstadoslibro().getIdEstadosLibros());
		CategoriasLibros categoria = this.daoCategory
				.findIdCategoriasLibros(libro.getCategoriaslibro().getIdCategoriaLibro());
		DisponibilidadLibros disponibilidad = this.daoDisponibilidad
				.findIdDisponibilidadLibros(libro.getDisponibilidadlibro().getIdDisponibilidadLibro());

		libro.setDisponibilidadlibro(disponibilidad);
		libro.setCategoriaslibro(categoria);
		libro.setEstadoslibro(estado);

		user.setRole(rol);
		addTransaccion.setUsuario(user);
		addTransaccion.setLibro(libro);
		addTransaccion.setEstadostransaccione(transa);

		TransaccionesDTO addedTransaccion = this.service.addTransacciones(addTransaccion);
		return new ResponseEntity<TransaccionesDTO>(addedTransaccion, HttpStatus.CREATED);
	}

	@PutMapping(value = "update-transaccion", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransaccionesDTO> putTransacciones(@RequestBody TransaccionesDTO updateTransacciones) {
		Transacciones updTransaccion = this.modelMapper.map(updateTransacciones, Transacciones.class);
		TransaccionesDTO updatedTransaccion = this.service.upTransacciones(updTransaccion);
		return new ResponseEntity<TransaccionesDTO>(updatedTransaccion, HttpStatus.OK);
	}

	@GetMapping(value = "reporte")
	public ResponseEntity<InputStreamResource> descargarReporte(@RequestParam LocalDate fechaInicio,
			@RequestParam LocalDate fechaFin) throws IOException {

		// LocalDate inicio = LocalDate.parse(fechaInicio);
		// LocalDate fin = LocalDate.parse(fechaFin);

		ByteArrayInputStream excelStream = service.generarReporteExcel(fechaInicio, fechaFin);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=transacciones.xlsx");

		return ResponseEntity.ok().headers(headers)
				.contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.body(new InputStreamResource(excelStream));
	}
}
