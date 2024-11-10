package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.DisponibilidadLibros;

public interface IDisponibilidadLibrosService {

	DisponibilidadLibros addDisponibilidadLibros(DisponibilidadLibros newDisponibilidadLibros);
	DisponibilidadLibros upDisponibilidadLibros(DisponibilidadLibros updateDisponibilidadLibros);
	DisponibilidadLibros findIdDisponibilidadLibros(int id);
	List<DisponibilidadLibros> listAllDisponibilidadLibros();
}
