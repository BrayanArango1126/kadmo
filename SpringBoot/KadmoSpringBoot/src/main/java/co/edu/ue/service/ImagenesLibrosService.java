package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.ImagenesLibrosDTO;
import co.edu.ue.entity.ImagenesLibros;
import co.edu.ue.repository.dao.IImagenesLibrosRepository;

@Service
public class ImagenesLibrosService implements IImagenesLibrosService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	IImagenesLibrosRepository dao;

	@Override
	public ImagenesLibrosDTO addImagenesLibros(ImagenesLibros newImagenesLibros) {
		ImagenesLibros addImagen = this.dao.insertImagenesLibros(newImagenesLibros);
		ImagenesLibrosDTO imagenesDTO = this.modelMapper.map(addImagen, ImagenesLibrosDTO.class);
		return imagenesDTO;
	}

	@Override
	public ImagenesLibrosDTO upImagenesLibros(ImagenesLibros updateImagenesLibros) {
		ImagenesLibros upImagen = this.dao.updateImagenesLibros(updateImagenesLibros);
		ImagenesLibrosDTO imagenesDTO = this.modelMapper.map(upImagen, ImagenesLibrosDTO.class);
		return imagenesDTO;
	}

	@Override
	public ImagenesLibrosDTO findIdImagenesLibros(int id) {
		ImagenesLibros imagenId = this.dao.findIdImagenesLibros(id);
		ImagenesLibrosDTO imagenesDTO = this.modelMapper.map(imagenId, ImagenesLibrosDTO.class);
		return imagenesDTO;
	}

	@Override
	public List<ImagenesLibrosDTO> listAllImagenesLibros() {
		List<ImagenesLibros> listAllImagenes = this.dao.listImagenesLibros();
		return listAllImagenes.stream().map(img -> this.modelMapper.map(img, ImagenesLibrosDTO.class)).collect(Collectors.toList());
	}
	
}
