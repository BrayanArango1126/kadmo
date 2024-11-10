package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Generos;

public interface IGenerosRepository {
	
	Generos insertGeneros(Generos newGeneros);
	Generos updateGeneros(Generos updateGeneros);
	Generos findIdGeneros(int id);
	List<Generos> listGeneros();

}
