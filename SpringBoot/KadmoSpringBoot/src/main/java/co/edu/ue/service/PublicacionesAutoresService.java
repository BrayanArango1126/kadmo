package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.PublicacionesAutores;
import co.edu.ue.repository.dao.IPublicacionesAutoresRepository;

@Service
public class PublicacionesAutoresService implements IPublicacionesAutoresService{

	@Autowired
	IPublicacionesAutoresRepository dao;

	@Override
	public PublicacionesAutores addPublicacionesAutores(PublicacionesAutores newPublicacionesAutores) {
		return this.dao.insertPublicacionesAutores(newPublicacionesAutores);
	}

	@Override
	public PublicacionesAutores upPublicacionesAutores(PublicacionesAutores updatePublicacionesAutores) {
		return this.dao.updatePublicacionesAutores(updatePublicacionesAutores);
	}

	@Override
	public PublicacionesAutores findIdPublicacionesAutores(int id) {
		return this.dao.findIdPublicacionesAutores(id);
	}

	@Override
	public List<PublicacionesAutores> listAllPublicacionesAutores() {
		return this.dao.listPublicacionesAutores();
	}
	
}
