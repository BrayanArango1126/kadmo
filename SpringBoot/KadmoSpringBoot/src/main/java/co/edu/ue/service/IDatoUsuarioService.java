package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.DatosUsuariosDTO;
import co.edu.ue.entity.DatosUsuarios;
import co.edu.ue.entity.Usuarios;

public interface IDatoUsuarioService {

	DatosUsuariosDTO addDatoUsuario(DatosUsuarios newDatoUsuario);
	DatosUsuariosDTO updDatoUsuario(DatosUsuarios updateDatoUsuario);
	DatosUsuariosDTO findIdDatoUsuario(int id);
	List<DatosUsuariosDTO> listAllDatosUsuarios();
	DatosUsuariosDTO findByIdUsuario(Usuarios idUsuario);
}
