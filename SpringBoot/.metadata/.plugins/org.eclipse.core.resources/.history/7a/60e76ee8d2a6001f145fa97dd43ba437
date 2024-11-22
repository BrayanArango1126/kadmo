package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.ImagenesLibros;
import co.edu.ue.repository.dao.IImagenesLibrosRepository;

@Service
public class ImagenesLibrosService implements IImagenesLibrosService {

	@Autowired
	IImagenesLibrosRepository dao;

	@Override
	public ImagenesLibros addImagenesLibros(ImagenesLibros newImagenesLibros) {
		return this.dao.insertImagenesLibros(newImagenesLibros);
	}

	@Override
	public ImagenesLibros upImagenesLibros(ImagenesLibros updateImagenesLibros) {
		return this.dao.updateImagenesLibros(updateImagenesLibros);
	}

	@Override
	public ImagenesLibros findIdImagenesLibros(int id) {
		return this.dao.findIdImagenesLibros(id);
	}

	@Override
	public List<ImagenesLibros> listAllImagenesLibros() {
		return this.dao.listImagenesLibros();
	}
	
}
