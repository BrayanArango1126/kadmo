package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.LibrosDTO;
import co.edu.ue.dto.LibrosFiltrosDTO;
import co.edu.ue.entity.LibroSpecification;
import co.edu.ue.entity.Libros;
import co.edu.ue.repository.dao.ILibrosRepository;
import co.edu.ue.repository.jpa.ILibrosJPA;

@Service
public class LibrosService implements ILibrosService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ILibrosRepository dao;

	@Autowired
	ILibrosJPA daoJPA;

	@Override
	public LibrosDTO addLibros(Libros newLibros) {
		Libros addLibros = this.dao.insertLibros(newLibros);
		LibrosDTO librosDTO = this.modelMapper.map(addLibros, LibrosDTO.class);
		return librosDTO;
	}

	@Override
	public LibrosDTO upLibros(Libros updateLibros) {
		Libros updLibros = this.dao.updateLibros(updateLibros);
		LibrosDTO librosDTO = this.modelMapper.map(updLibros, LibrosDTO.class);
		return librosDTO;
	}

	@Override
	public LibrosDTO findIdLibros(int id) {
		Libros librosId = this.dao.findIdLibros(id);
		LibrosDTO librosDTO = this.modelMapper.map(librosId, LibrosDTO.class);
		return librosDTO;
	}

	@Override
	public List<LibrosDTO> listAllLibros() {
		List<Libros> listAllLibros = this.dao.listLibros();
		return listAllLibros.stream().map(libro -> this.modelMapper.map(libro, LibrosDTO.class))
				.collect(Collectors.toList());
	}

	public List<LibrosDTO> listAllLibrosByFilter(LibrosFiltrosDTO filtros) {
		Specification<Libros> spec = LibroSpecification.conFiltros(filtros);

		List<Libros> listAllLibros = this.daoJPA.findAll(spec);

		List<LibrosDTO> listAllLibrosDTO = listAllLibros.stream().map(libro -> this.modelMapper.map(libro, LibrosDTO.class))
				.collect(Collectors.toList());

		return listAllLibrosDTO;
	}

}
