package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.PublicacionesAutores;

public interface IPublicacionesAutoresRepository {

	PublicacionesAutores insertPublicacionesAutores(PublicacionesAutores newPublicacionesAutores);
	PublicacionesAutores updatePublicacionesAutores(PublicacionesAutores updatePublicacionesAutores);
	PublicacionesAutores findIdPublicacionesAutores(int id);
	List<PublicacionesAutores> listPublicacionesAutores();
}
