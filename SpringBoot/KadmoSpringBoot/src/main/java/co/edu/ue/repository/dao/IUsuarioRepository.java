package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Usuarios;

public interface IUsuarioRepository {
	Usuarios insertUsuario(Usuarios newUsuario);

	Usuarios updateUsuario(Usuarios updateUsuario);

	Usuarios findIdUsuario(int id);

	List<Usuarios> listUsuarios();

	Usuarios findByCorreo(String correo);
}
