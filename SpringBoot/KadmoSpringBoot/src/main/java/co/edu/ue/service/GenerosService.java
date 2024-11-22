package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.GenerosDTO;
import co.edu.ue.entity.Generos;
import co.edu.ue.repository.dao.IGenerosRepository;

@Service
public class GenerosService implements IGenerosService{
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IGenerosRepository dao;

	@Override
	public GenerosDTO addGeneros(Generos newGeneros) {
		Generos addGenero = this.dao.insertGeneros(newGeneros);
		GenerosDTO generoDTO = modelMapper.map(addGenero, GenerosDTO.class);
		return generoDTO;
	}

	@Override
	public GenerosDTO upGeneros(Generos updateGeneros) {
		Generos updateGenero = this.dao.updateGeneros(updateGeneros);
		GenerosDTO generoDTO = modelMapper.map(updateGenero, GenerosDTO.class);
		return generoDTO;
	}

	@Override
	public GenerosDTO findIdGeneros(int id) {
		Generos findGenero = this.dao.findIdGeneros(id);
		GenerosDTO generoDTO = modelMapper.map(findGenero, GenerosDTO.class);
		return generoDTO;
	}

	@Override
	public List<GenerosDTO> listAllGeneros() {
		List<Generos> listGeneros = this.dao.listGeneros();
		return listGeneros.stream().map(genero -> modelMapper.map(genero, GenerosDTO.class)).collect(Collectors.toList());
	}
	
}
