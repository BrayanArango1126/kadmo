package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.EstadosLibrosDTO;
import co.edu.ue.entity.EstadosLibros;
import co.edu.ue.repository.dao.IEstadosLibrosRepository;

@Service
public class EstadosLibrosService implements IEstadosLibrosService{
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IEstadosLibrosRepository dao;

	@Override
	public EstadosLibrosDTO addEstadosLibros(EstadosLibros newEstadosLibros) {
		EstadosLibros addEstadoLibro = this.dao.insertEstadosLibros(newEstadosLibros);
		EstadosLibrosDTO estadoLibro = this.modelMapper.map(addEstadoLibro, EstadosLibrosDTO.class);
		return estadoLibro;
	}

	@Override
	public EstadosLibrosDTO upEstadosLibros(EstadosLibros updateEstadosLibros) {
		EstadosLibros upEstadoLibro = this.dao.updateEstadosLibros(updateEstadosLibros);
		EstadosLibrosDTO estadoLibro = this.modelMapper.map(upEstadoLibro, EstadosLibrosDTO.class);
		return estadoLibro;
	}

	@Override
	public EstadosLibrosDTO findIdEstadosLibros(int id) {
		EstadosLibros estadoLibroId = this.dao.findIdEstadosLibros(id);
		EstadosLibrosDTO estadoLibro = this.modelMapper.map(estadoLibroId, EstadosLibrosDTO.class);
		return estadoLibro;
	}

	@Override
	public List<EstadosLibrosDTO> listAllEstadosLibros() {
		List<EstadosLibros> listAllEstadosLibros = this.dao.listEstadosLibros();
		return listAllEstadosLibros.stream().map(estado -> this.modelMapper.map(estado, EstadosLibrosDTO.class)).collect(Collectors.toList());
	}
}
