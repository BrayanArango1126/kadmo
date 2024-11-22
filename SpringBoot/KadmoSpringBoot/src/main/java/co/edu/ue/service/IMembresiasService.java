package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.MembresiasDTO;
import co.edu.ue.entity.Membresias;

public interface IMembresiasService {

	MembresiasDTO addMembresias(Membresias newMembresias);
	MembresiasDTO upMembresias(Membresias updateMembresias);
	MembresiasDTO findIdMembresias(int id);
	List<MembresiasDTO> listAllMembresias();
}
