package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.MembresiasDTO;
import co.edu.ue.entity.Membresias;
import co.edu.ue.repository.dao.IMembresiasRepository;

@Service
public class MembresiasService implements IMembresiasService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	IMembresiasRepository dao;

	@Override
	public MembresiasDTO addMembresias(Membresias newMembresias) {
		Membresias addMembresia = this.dao.insertMembresias(newMembresias);
		MembresiasDTO membresiasDTO = this.modelMapper.map(addMembresia, MembresiasDTO.class);
		return membresiasDTO;
	}

	@Override
	public MembresiasDTO upMembresias(Membresias updateMembresias) {
		Membresias updMembresia = this.dao.updateMembresias(updateMembresias);
		MembresiasDTO membresiasDTO = this.modelMapper.map(updMembresia, MembresiasDTO.class);
		return membresiasDTO;
	}

	@Override
	public MembresiasDTO findIdMembresias(int id) {
		Membresias idMembresia = this.dao.findIdMembresias(id);
		MembresiasDTO membresiasDTO = this.modelMapper.map(idMembresia, MembresiasDTO.class);
		return membresiasDTO;
	}

	@Override
	public List<MembresiasDTO> listAllMembresias() {
		List<Membresias> listAllMembresias = this.dao.listMembresias();
		return listAllMembresias.stream().map(membresia -> this.modelMapper.map(membresia, MembresiasDTO.class)).collect(Collectors.toList());
	}
	
	
}
