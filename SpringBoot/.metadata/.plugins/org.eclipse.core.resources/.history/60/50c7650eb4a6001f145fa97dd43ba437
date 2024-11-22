package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.DisponibilidadLibros;
import co.edu.ue.repository.dao.IDisponibilidadLibrosRepository;

@Service
public class DisponibilidadLibrosService implements IDisponibilidadLibrosService {

	@Autowired
	IDisponibilidadLibrosRepository dao;

	@Override
	public DisponibilidadLibros addDisponibilidadLibros(DisponibilidadLibros newDisponibilidadLibros) {
		return this.dao.insertDisponibilidadLibros(newDisponibilidadLibros);
	}

	@Override
	public DisponibilidadLibros upDisponibilidadLibros(DisponibilidadLibros updateDisponibilidadLibros) {
		return this.dao.updateDisponibilidadLibros(updateDisponibilidadLibros);
	}

	@Override
	public DisponibilidadLibros findIdDisponibilidadLibros(int id) {
		return this.dao.findIdDisponibilidadLibros(id);
	}

	@Override
	public List<DisponibilidadLibros> listAllDisponibilidadLibros() {
		return this.dao.listDisponibilidadLibros();
	}
}
