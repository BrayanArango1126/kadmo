package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Editoriales;

public interface IEditorialesRepository {
	
	Editoriales insertEditoriales(Editoriales newEditoriales);
	Editoriales updateEditoriales(Editoriales updateEditoriales);
	Editoriales findIdEditoriales(int id);
	List<Editoriales> listEditoriales();

}
