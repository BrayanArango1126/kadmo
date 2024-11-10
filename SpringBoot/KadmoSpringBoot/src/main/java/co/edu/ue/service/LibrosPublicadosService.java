package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.LibrosPublicados;
import co.edu.ue.repository.dao.ILibrosPublicadosRepository;

@Service
public class LibrosPublicadosService implements ILibrosPublicadosService{

	@Autowired
	ILibrosPublicadosRepository dao;

	@Override
	public LibrosPublicados addLibrosPublicados(LibrosPublicados newLibrosPublicados) {
		return this.dao.insertLibrosPublicados(newLibrosPublicados);
	}

	@Override
	public LibrosPublicados upLibrosPublicados(LibrosPublicados updateLibrosPublicados) {
		return this.dao.updateLibrosPublicados(updateLibrosPublicados);
	}

	@Override
	public LibrosPublicados findIdLibrosPublicados(int id) {
		return this.dao.findIdLibrosPublicados(id);
	}

	@Override
	public List<LibrosPublicados> listAllLibrosPublicados() {
		return this.dao.listLibrosPublicados();
	}
}
