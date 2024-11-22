package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.GenerosDTO;
import co.edu.ue.entity.Generos;

public interface IGenerosService {

	GenerosDTO addGeneros(Generos newGeneros);
	GenerosDTO upGeneros(Generos updateGeneros);
	GenerosDTO findIdGeneros(int id);
	List<GenerosDTO> listAllGeneros();
}
