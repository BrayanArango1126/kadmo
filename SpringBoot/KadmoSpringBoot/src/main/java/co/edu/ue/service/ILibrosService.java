package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.LibrosDTO;
import co.edu.ue.dto.LibrosFiltrosDTO;
import co.edu.ue.entity.Libros;

public interface ILibrosService {

	LibrosDTO addLibros(Libros newLibros);

	LibrosDTO upLibros(Libros updateLibros);

	LibrosDTO findIdLibros(int id);

	List<LibrosDTO> listAllLibros();

	List<LibrosDTO> listAllLibrosByFilter(LibrosFiltrosDTO filtros);
}
