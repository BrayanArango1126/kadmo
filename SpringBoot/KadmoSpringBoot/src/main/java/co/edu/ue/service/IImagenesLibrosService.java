package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.ImagenesLibrosDTO;
import co.edu.ue.entity.ImagenesLibros;
import co.edu.ue.entity.Libros;

public interface IImagenesLibrosService {

	ImagenesLibrosDTO addImagenesLibros(ImagenesLibros newImagenesLibros);

	ImagenesLibrosDTO upImagenesLibros(ImagenesLibros updateImagenesLibros);

	ImagenesLibrosDTO findIdImagenesLibros(int id);

	List<ImagenesLibrosDTO> listAllImagenesLibros();

	ImagenesLibrosDTO findByLibro(Libros libro);
}
