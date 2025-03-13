package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.ImagenesLibros;
import co.edu.ue.entity.Libros;
import co.edu.ue.repository.jpa.IImagenesLibrosJPA;

@Repository
public class ImagenesLibrosRepository implements IImagenesLibrosRepository {

	@Autowired
	IImagenesLibrosJPA jpa;

	@Override
	public ImagenesLibros insertImagenesLibros(ImagenesLibros newImagenesLibros) {
		return this.jpa.save(newImagenesLibros);
	}

	@Override
	public ImagenesLibros updateImagenesLibros(ImagenesLibros updateImagenesLibros) {
		return this.jpa.save(updateImagenesLibros);
	}

	@Override
	public ImagenesLibros findIdImagenesLibros(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<ImagenesLibros> listImagenesLibros() {
		return this.jpa.findAll();
	}

	@Override
	public ImagenesLibros findByLibro(Libros libro) {
		return this.jpa.findByLibro(libro);
	}
}
