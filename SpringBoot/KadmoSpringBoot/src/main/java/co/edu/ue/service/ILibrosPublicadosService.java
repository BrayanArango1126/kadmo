package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.LibrosPublicadosDTO;
import co.edu.ue.entity.LibrosPublicados;

public interface ILibrosPublicadosService {

	LibrosPublicadosDTO addLibrosPublicados(LibrosPublicados newLibrosPublicados);
	LibrosPublicadosDTO upLibrosPublicados(LibrosPublicados updateLibrosPublicados);
	LibrosPublicadosDTO findIdLibrosPublicados(int id);
	List<LibrosPublicadosDTO> listAllLibrosPublicados();
}
