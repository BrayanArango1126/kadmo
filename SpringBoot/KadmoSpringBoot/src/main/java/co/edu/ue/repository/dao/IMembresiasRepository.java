package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Membresias;

public interface IMembresiasRepository {

	Membresias insertMembresias(Membresias newMembresias);
	Membresias updateMembresias(Membresias updateMembresias);
	Membresias findIdMembresias(int id);
	List<Membresias> listMembresias();
}
