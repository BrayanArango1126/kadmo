package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.LibrosPublicadosDTO;
import co.edu.ue.entity.LibrosPublicados;
import co.edu.ue.repository.dao.ILibrosPublicadosRepository;

@Service
public class LibrosPublicadosService implements ILibrosPublicadosService{
	
	@Autowired
    private ModelMapper modelMapper; 

	@Autowired
	ILibrosPublicadosRepository dao;

	@Override
	public LibrosPublicadosDTO addLibrosPublicados(LibrosPublicados newLibrosPublicados) {
		LibrosPublicados addLibrosPublicados = this.dao.insertLibrosPublicados(newLibrosPublicados);
		LibrosPublicadosDTO librosPublicadosDTO = this.modelMapper.map(addLibrosPublicados, LibrosPublicadosDTO.class);
		return librosPublicadosDTO;
	}

	@Override
	public LibrosPublicadosDTO upLibrosPublicados(LibrosPublicados updateLibrosPublicados) {
		LibrosPublicados upLibrosPublicados = this.dao.updateLibrosPublicados(updateLibrosPublicados);
		LibrosPublicadosDTO librosPublicadosDTO = this.modelMapper.map(upLibrosPublicados, LibrosPublicadosDTO.class);
		return librosPublicadosDTO;
	}

	@Override
	public LibrosPublicadosDTO findIdLibrosPublicados(int id) {
		LibrosPublicados idLibrosPublicados = this.dao.findIdLibrosPublicados(id);
		LibrosPublicadosDTO librosPublicadosDTO = this.modelMapper.map(idLibrosPublicados, LibrosPublicadosDTO.class);
		return librosPublicadosDTO;
	}

	@Override
	public List<LibrosPublicadosDTO> listAllLibrosPublicados() {
		List<LibrosPublicados> listAllLibros = this.dao.listLibrosPublicados();
		return listAllLibros.stream().map(lib -> this.modelMapper.map(lib, LibrosPublicadosDTO.class)).collect(Collectors.toList());
	}
}
