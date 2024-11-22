package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.DatosUsuariosDTO;
import co.edu.ue.entity.DatosUsuarios;

public interface IDatoUsuarioService {

	DatosUsuariosDTO addDatoUsuario(DatosUsuarios newDatoUsuario);
	DatosUsuariosDTO updDatoUsuario(DatosUsuarios updateDatoUsuario);
	DatosUsuariosDTO findIdDatoUsuario(int id);
	List<DatosUsuariosDTO> listAllDatosUsuarios();
}
