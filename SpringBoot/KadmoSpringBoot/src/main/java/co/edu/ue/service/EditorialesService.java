package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.EditorialesDTO;
import co.edu.ue.entity.Editoriales;
import co.edu.ue.repository.dao.IEditorialesRepository;

@Service
public class EditorialesService implements IEditorialesService{
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IEditorialesRepository dao;

	@Override
	public EditorialesDTO addEditoriales(Editoriales newEditoriales) {
		Editoriales addEditorial = this.dao.insertEditoriales(newEditoriales);
		EditorialesDTO editorialDTO = this.modelMapper.map(addEditorial, EditorialesDTO.class);
		return editorialDTO;
	}

	@Override
	public EditorialesDTO upEditoriales(Editoriales updateEditoriales) {
		Editoriales upEditorial = this.dao.updateEditoriales(updateEditoriales);
		EditorialesDTO editorialDTO = this.modelMapper.map(upEditorial, EditorialesDTO.class);
		return editorialDTO;
	}

	@Override
	public EditorialesDTO findIdEditoriales(int id) {
		Editoriales editorialId = this.dao.findIdEditoriales(id);
		EditorialesDTO editorialDTO = this.modelMapper.map(editorialId, EditorialesDTO.class);
		return editorialDTO;
	}

	@Override
	public List<EditorialesDTO> listAllEditoriales() {
		List<Editoriales> listAllEditoriales = this.dao.listEditoriales();
		return listAllEditoriales.stream().map(edit-> this.modelMapper.map(edit, EditorialesDTO.class)).collect(Collectors.toList());
	}
	
	
}
