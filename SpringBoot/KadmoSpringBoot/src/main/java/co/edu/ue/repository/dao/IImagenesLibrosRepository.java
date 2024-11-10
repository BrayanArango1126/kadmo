package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.ImagenesLibros;

public interface IImagenesLibrosRepository {

	ImagenesLibros insertImagenesLibros(ImagenesLibros newImagenesLibros);
	ImagenesLibros updateImagenesLibros(ImagenesLibros updateImagenesLibros);
	ImagenesLibros findIdImagenesLibros(int id);
	List<ImagenesLibros> listImagenesLibros();
}
