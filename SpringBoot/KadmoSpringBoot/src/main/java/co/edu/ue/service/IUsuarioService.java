package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.UsuariosDTO;
import co.edu.ue.entity.Usuarios;

public interface IUsuarioService {

	UsuariosDTO addUsuario(Usuarios newUsuario);

	UsuariosDTO updUsuario(Usuarios updateUsuario);

	UsuariosDTO findIdUsuario(int id);

	List<UsuariosDTO> listAllUsuarios();
}
