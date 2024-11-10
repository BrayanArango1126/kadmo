package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Generos;

public interface IGenerosService {

	Generos addGeneros(Generos newGeneros);
	Generos upGeneros(Generos updateGeneros);
	Generos findIdGeneros(int id);
	List<Generos> listAllGeneros();
}
