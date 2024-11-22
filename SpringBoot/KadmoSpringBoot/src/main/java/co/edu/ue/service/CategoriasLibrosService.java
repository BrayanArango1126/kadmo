package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.CategoriasLibrosDTO;
import co.edu.ue.entity.CategoriasLibros;
import co.edu.ue.repository.dao.ICategoriaLibrosRepository;

@Service
public class CategoriasLibrosService implements ICategoriasLibrosService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	ICategoriaLibrosRepository dao;
	
	@Override
	public CategoriasLibrosDTO addCategoriasLibros(CategoriasLibros newCategoriasLibros) {
		CategoriasLibros addCategoria = this.dao.insertCategoriasLibros(newCategoriasLibros);
		CategoriasLibrosDTO categoriaLibroDTO = this.modelMapper.map(addCategoria, CategoriasLibrosDTO.class);
		return categoriaLibroDTO;
	}

	@Override
	public CategoriasLibrosDTO upCategoriasLibros(CategoriasLibros updateCategoriasLibros) {
		CategoriasLibros upCategoria = this.dao.updateCategoriasLibros(updateCategoriasLibros);
		CategoriasLibrosDTO categoriaLibroDTO = this.modelMapper.map(upCategoria, CategoriasLibrosDTO.class);
		return categoriaLibroDTO;
	}

	@Override
	public CategoriasLibrosDTO findIdCategoriasLibros(int id) {
		CategoriasLibros categoryId = this.dao.findIdCategoriasLibros(id);
		CategoriasLibrosDTO  categoriaLibroDTO = this.modelMapper.map(categoryId, CategoriasLibrosDTO.class);
		return categoriaLibroDTO ;
	}

	@Override
	public List<CategoriasLibrosDTO> listAllCategoriasLibros() {
		List<CategoriasLibros> listCategoryId = this.dao.listCategoriasLibros();
		return listCategoryId.stream().map(category-> modelMapper.map(category, CategoriasLibrosDTO.class)).collect(Collectors.toList());
	}

	
}
