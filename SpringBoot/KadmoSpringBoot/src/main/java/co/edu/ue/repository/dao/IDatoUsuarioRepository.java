package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.DatosUsuarios;
import co.edu.ue.entity.Usuarios;

public interface IDatoUsuarioRepository {

	DatosUsuarios insertDatoUsuario(DatosUsuarios newDatoUsuario);
	DatosUsuarios updateDatoUsuario(DatosUsuarios updateDatoUsuario);
	DatosUsuarios findIdDatoUsuario(int id);
	List<DatosUsuarios> listDatosUsuarios();
	DatosUsuarios findByUsuario(Usuarios idUsuario);
}
