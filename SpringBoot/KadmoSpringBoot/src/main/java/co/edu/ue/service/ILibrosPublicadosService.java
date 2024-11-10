package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.LibrosPublicados;

public interface ILibrosPublicadosService {

	LibrosPublicados addLibrosPublicados(LibrosPublicados newLibrosPublicados);
	LibrosPublicados upLibrosPublicados(LibrosPublicados updateLibrosPublicados);
	LibrosPublicados findIdLibrosPublicados(int id);
	List<LibrosPublicados> listAllLibrosPublicados();
}
