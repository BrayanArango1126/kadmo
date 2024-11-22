package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Membresias;
import co.edu.ue.repository.dao.IMembresiasRepository;

@Service
public class MembresiasService implements IMembresiasService{

	@Autowired
	IMembresiasRepository dao;

	@Override
	public Membresias addMembresias(Membresias newMembresias) {
		return this.dao.insertMembresias(newMembresias);
	}

	@Override
	public Membresias upMembresias(Membresias updateMembresias) {
		return this.dao.updateMembresias(updateMembresias);
	}

	@Override
	public Membresias findIdMembresias(int id) {
		return this.dao.findIdMembresias(id);
	}

	@Override
	public List<Membresias> listAllMembresias() {
		return this.dao.listMembresias();
	}
	
	
}
