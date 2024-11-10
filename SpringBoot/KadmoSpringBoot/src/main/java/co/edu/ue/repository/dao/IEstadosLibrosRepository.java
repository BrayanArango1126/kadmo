package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.EstadosLibros;

public interface IEstadosLibrosRepository {

	EstadosLibros insertEstadosLibros(EstadosLibros newEstadosLibros);
	EstadosLibros updateEstadosLibros(EstadosLibros updateEstadosLibros);
	EstadosLibros findIdEstadosLibros(int id);
	List<EstadosLibros> listEstadosLibros();
}
