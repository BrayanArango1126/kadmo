package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.PublicacionesAutores;

public interface IPublicacionesAutoresService {

	PublicacionesAutores addPublicacionesAutores(PublicacionesAutores newPublicacionesAutores);
	PublicacionesAutores upPublicacionesAutores(PublicacionesAutores updatePublicacionesAutores);
	PublicacionesAutores findIdPublicacionesAutores(int id);
	List<PublicacionesAutores> listAllPublicacionesAutores();
}
