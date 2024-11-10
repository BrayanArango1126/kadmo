package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.LibrosPublicados;
import co.edu.ue.repository.jpa.ILibrosPublicadosJPA;

@Repository
public class LibrosPublicadosRepository implements ILibrosPublicadosRepository{

	@Autowired
	ILibrosPublicadosJPA jpa;
	
	@Override
	public LibrosPublicados insertLibrosPublicados(LibrosPublicados newLibrosPublicados) {
		return this.jpa.save(newLibrosPublicados);
	}

	@Override
	public LibrosPublicados updateLibrosPublicados(LibrosPublicados updateLibrosPublicados) {
		return this.jpa.save(updateLibrosPublicados);
	}

	@Override
	public LibrosPublicados findIdLibrosPublicados(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<LibrosPublicados> listLibrosPublicados() {
		return this.jpa.findAll();
	}

}
