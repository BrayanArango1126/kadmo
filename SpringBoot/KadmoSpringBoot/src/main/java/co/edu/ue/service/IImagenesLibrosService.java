package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.ImagenesLibros;

public interface IImagenesLibrosService {

	ImagenesLibros addImagenesLibros(ImagenesLibros newImagenesLibros);
	ImagenesLibros upImagenesLibros(ImagenesLibros updateImagenesLibros);
	ImagenesLibros findIdImagenesLibros(int id);
	List<ImagenesLibros> listAllImagenesLibros();
}
