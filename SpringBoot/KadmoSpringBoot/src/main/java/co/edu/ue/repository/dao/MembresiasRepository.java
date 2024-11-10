package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Membresias;
import co.edu.ue.repository.jpa.IMembresiasJPA;

@Repository
public class MembresiasRepository implements IMembresiasRepository{

	@Autowired
	IMembresiasJPA jpa;

	@Override
	public Membresias insertMembresias(Membresias newMembresias) {
		return this.jpa.save(newMembresias);
	}

	@Override
	public Membresias updateMembresias(Membresias updateMembresias) {
		return this.jpa.save(updateMembresias);
	}

	@Override
	public Membresias findIdMembresias(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<Membresias> listMembresias() {
		return this.jpa.findAll();
	}
}
