package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Editoriales;
import co.edu.ue.repository.dao.IEditorialesRepository;

@Service
public class EditorialesService implements IEditorialesService{

	@Autowired
	IEditorialesRepository dao;

	@Override
	public Editoriales addEditoriales(Editoriales newEditoriales) {
		return this.dao.insertEditoriales(newEditoriales);
	}

	@Override
	public Editoriales upEditoriales(Editoriales updateEditoriales) {
		return this.dao.updateEditoriales(updateEditoriales);
	}

	@Override
	public Editoriales findIdEditoriales(int id) {
		return this.dao.findIdEditoriales(id);
	}

	@Override
	public List<Editoriales> listAllEditoriales() {
		return this.dao.listEditoriales();
	}
	
	
}
