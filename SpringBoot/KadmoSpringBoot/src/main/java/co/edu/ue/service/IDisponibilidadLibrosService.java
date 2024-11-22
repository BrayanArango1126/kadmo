package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.DisponibilidadLibrosDTO;
import co.edu.ue.entity.DisponibilidadLibros;

public interface IDisponibilidadLibrosService {

	DisponibilidadLibrosDTO addDisponibilidadLibros(DisponibilidadLibros newDisponibilidadLibros);
	DisponibilidadLibrosDTO upDisponibilidadLibros(DisponibilidadLibros updateDisponibilidadLibros);
	DisponibilidadLibrosDTO findIdDisponibilidadLibros(int id);
	List<DisponibilidadLibrosDTO> listAllDisponibilidadLibros();
}
