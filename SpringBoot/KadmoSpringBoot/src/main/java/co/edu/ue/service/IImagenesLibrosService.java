package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.ImagenesLibrosDTO;
import co.edu.ue.entity.ImagenesLibros;

public interface IImagenesLibrosService {

	ImagenesLibrosDTO addImagenesLibros(ImagenesLibros newImagenesLibros);
	ImagenesLibrosDTO upImagenesLibros(ImagenesLibros updateImagenesLibros);
	ImagenesLibrosDTO findIdImagenesLibros(int id);
	List<ImagenesLibrosDTO> listAllImagenesLibros();
}
