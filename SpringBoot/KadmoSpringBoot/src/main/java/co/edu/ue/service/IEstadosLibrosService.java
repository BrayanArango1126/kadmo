package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.EstadosLibrosDTO;
import co.edu.ue.entity.EstadosLibros;

public interface IEstadosLibrosService {

	EstadosLibrosDTO addEstadosLibros(EstadosLibros newEstadosLibros);
	EstadosLibrosDTO upEstadosLibros(EstadosLibros updateEstadosLibros);
	EstadosLibrosDTO findIdEstadosLibros(int id);
	List<EstadosLibrosDTO> listAllEstadosLibros();
}
