package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.CategoriasLibrosDTO;
import co.edu.ue.entity.CategoriasLibros;

public interface ICategoriasLibrosService {

	CategoriasLibrosDTO addCategoriasLibros(CategoriasLibros newCategoriasLibros);
	CategoriasLibrosDTO upCategoriasLibros(CategoriasLibros updateCategoriasLibros);
	CategoriasLibrosDTO findIdCategoriasLibros(int id);
	List<CategoriasLibrosDTO> listAllCategoriasLibros();
}
