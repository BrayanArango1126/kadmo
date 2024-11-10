package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Generos;
import co.edu.ue.repository.dao.IGenerosRepository;

@Service
public class GenerosService implements IGenerosService{

	@Autowired
	IGenerosRepository dao;

	@Override
	public Generos addGeneros(Generos newGeneros) {
		return this.dao.insertGeneros(newGeneros);
	}

	@Override
	public Generos upGeneros(Generos updateGeneros) {
		return this.dao.updateGeneros(updateGeneros);
	}

	@Override
	public Generos findIdGeneros(int id) {
		return this.dao.findIdGeneros(id);
	}

	@Override
	public List<Generos> listAllGeneros() {
		return this.dao.listGeneros();
	}
	
}
