package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Generos;
import co.edu.ue.repository.jpa.IGenerosJPA;

@Repository
public class GenerosRepository  implements IGenerosRepository{

	@Autowired
	IGenerosJPA jpa;

	@Override
	public Generos insertGeneros(Generos newGeneros) {
		return this.jpa.save(newGeneros);
	}

	@Override
	public Generos updateGeneros(Generos updateGeneros) {
		return this.jpa.save(updateGeneros);
	}

	@Override
	public Generos findIdGeneros(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<Generos> listGeneros() {
		return this.jpa.findAll();
	}

}
