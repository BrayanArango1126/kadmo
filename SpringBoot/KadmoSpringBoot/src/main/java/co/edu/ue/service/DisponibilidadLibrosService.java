package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.DisponibilidadLibrosDTO;
import co.edu.ue.entity.DisponibilidadLibros;
import co.edu.ue.repository.dao.IDisponibilidadLibrosRepository;

@Service
public class DisponibilidadLibrosService implements IDisponibilidadLibrosService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IDisponibilidadLibrosRepository dao;

	@Override
	public DisponibilidadLibrosDTO addDisponibilidadLibros(DisponibilidadLibros newDisponibilidadLibros) {
		DisponibilidadLibros addDisponibilidadLibro = this.dao.insertDisponibilidadLibros(newDisponibilidadLibros);
		DisponibilidadLibrosDTO disponibilidadLibroDTO = modelMapper.map(addDisponibilidadLibro, DisponibilidadLibrosDTO.class);
		return disponibilidadLibroDTO;
	}

	@Override
	public DisponibilidadLibrosDTO upDisponibilidadLibros(DisponibilidadLibros updateDisponibilidadLibros) {
		DisponibilidadLibros updDisponibilidadLibro = this.dao.updateDisponibilidadLibros(updateDisponibilidadLibros);
		DisponibilidadLibrosDTO disponibilidadLibroDTO = modelMapper.map(updDisponibilidadLibro, DisponibilidadLibrosDTO.class);
		return disponibilidadLibroDTO;
	}

	@Override
	public DisponibilidadLibrosDTO findIdDisponibilidadLibros(int id) {
		DisponibilidadLibros disponibilidadId = this.dao.findIdDisponibilidadLibros(id);
		DisponibilidadLibrosDTO disponibilidadLibroDTO = modelMapper.map(disponibilidadId, DisponibilidadLibrosDTO.class);
		return disponibilidadLibroDTO;
	}

	@Override
	public List<DisponibilidadLibrosDTO> listAllDisponibilidadLibros() {
		List<DisponibilidadLibros> listAllDisponibilidades = this.dao.listDisponibilidadLibros();
		return listAllDisponibilidades.stream().map(dispo -> modelMapper.map(dispo, DisponibilidadLibrosDTO.class)).collect(Collectors.toList());
	}
}
