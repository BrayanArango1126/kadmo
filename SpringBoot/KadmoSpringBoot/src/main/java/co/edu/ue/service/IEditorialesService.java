package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.EditorialesDTO;
import co.edu.ue.entity.Editoriales;

public interface IEditorialesService {

	EditorialesDTO addEditoriales(Editoriales newEditoriales);
	EditorialesDTO upEditoriales(Editoriales updateEditoriales);
	EditorialesDTO findIdEditoriales(int id);
	List<EditorialesDTO> listAllEditoriales();
}
