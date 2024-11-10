package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.LibrosPublicados;

public interface ILibrosPublicadosRepository {

	LibrosPublicados insertLibrosPublicados(LibrosPublicados newLibrosPublicados);
	LibrosPublicados updateLibrosPublicados(LibrosPublicados updateLibrosPublicados);
	LibrosPublicados findIdLibrosPublicados(int id);
	List<LibrosPublicados> listLibrosPublicados();
}
