package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.CalificacionesDTO;
import co.edu.ue.entity.Calificaciones;
import co.edu.ue.entity.Libros;
import co.edu.ue.repository.dao.ICalificacionesRepository;

@Service
public class CalificacionesService implements ICalificacionesService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	ICalificacionesRepository dao;

	@Override
	public CalificacionesDTO addCalificaciones(Calificaciones newCalificaciones) {
		Calificaciones addCalificacion = this.dao.insertCalificaciones(newCalificaciones);
		CalificacionesDTO calificacionDTO = this.modelMapper.map(addCalificacion, CalificacionesDTO.class);
		return calificacionDTO;
	}

	@Override
	public CalificacionesDTO upCalificaciones(Calificaciones updateCalificaciones) {
		Calificaciones upCalificacion = this.dao.updateCalificaciones(updateCalificaciones);
		CalificacionesDTO calificacionDTO = this.modelMapper.map(upCalificacion, CalificacionesDTO.class);
		return calificacionDTO;
	}

	@Override
	public CalificacionesDTO findIdCalificaciones(int id) {
		Calificaciones idCalificacion = this.dao.findIdCalificaciones(id);
		CalificacionesDTO calificacionDTO = this.modelMapper.map(idCalificacion, CalificacionesDTO.class);
		return calificacionDTO;
	}

	@Override
	public List<CalificacionesDTO> listAllCalificaciones() {
		List<Calificaciones> listAllCalificaciones = this.dao.listCalificaciones();
		return listAllCalificaciones.stream().map(cal -> this.modelMapper.map(cal, CalificacionesDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<CalificacionesDTO> findByIdLibro(Libros libro) {
		List<Calificaciones> calificacionesLibro = this.dao.findByIdLibro(libro);
		return calificacionesLibro.stream().map(cal -> this.modelMapper.map(cal, CalificacionesDTO.class)).collect(Collectors.toList());
	}
	
	
}
