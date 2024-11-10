package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Editoriales;
import co.edu.ue.repository.jpa.IEditorialesJPA;

@Repository
public class EditorialesRepository implements IEditorialesRepository{

	@Autowired
	IEditorialesJPA jpa;

	@Override
	public Editoriales insertEditoriales(Editoriales newEditoriales) {
		return this.jpa.save(newEditoriales);
	}

	@Override
	public Editoriales updateEditoriales(Editoriales updateEditoriales) {
		return this.jpa.save(updateEditoriales);
	}

	@Override
	public Editoriales findIdEditoriales(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<Editoriales> listEditoriales() {
		return this.jpa.findAll();
	}
}
