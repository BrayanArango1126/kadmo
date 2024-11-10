package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.DisponibilidadLibros;

public interface IDisponibilidadLibrosRepository {

	DisponibilidadLibros insertDisponibilidadLibros(DisponibilidadLibros newDisponibilidadLibros);
	DisponibilidadLibros updateDisponibilidadLibros(DisponibilidadLibros updateDisponibilidadLibros);
	DisponibilidadLibros findIdDisponibilidadLibros(int id);
	List<DisponibilidadLibros> listDisponibilidadLibros();
}
