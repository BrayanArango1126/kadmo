package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.PublicacionesAutores;
import co.edu.ue.repository.jpa.IPublicacionesAutoresJPA;

@Repository
public class PublicacionesAutoresRepository implements IPublicacionesAutoresRepository {

	@Autowired
	IPublicacionesAutoresJPA jpa;

	@Override
	public PublicacionesAutores insertPublicacionesAutores(PublicacionesAutores newPublicacionesAutores) {
		return this.jpa.save(newPublicacionesAutores);
	}

	@Override
	public PublicacionesAutores updatePublicacionesAutores(PublicacionesAutores updatePublicacionesAutores) {
		return this.jpa.save(updatePublicacionesAutores);
	}

	@Override
	public PublicacionesAutores findIdPublicacionesAutores(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<PublicacionesAutores> listPublicacionesAutores() {
		return this.jpa.findAll();
	}
}
