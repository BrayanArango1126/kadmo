package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.EstadosLibros;

public interface IEstadosLibrosService {

	EstadosLibros addEstadosLibros(EstadosLibros newEstadosLibros);
	EstadosLibros upEstadosLibros(EstadosLibros updateEstadosLibros);
	EstadosLibros findIdEstadosLibros(int id);
	List<EstadosLibros> listAllEstadosLibros();
}
