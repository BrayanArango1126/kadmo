package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.jpa.IUsuarioJPA;

@Repository
public class UsuarioRepository implements IUsuarioRepository{

	@Autowired
	IUsuarioJPA jpa;

	@Override
	public Usuarios insertUsuario(Usuarios newUsuario) {
		return this.jpa.save(newUsuario);
	}

	@Override
	public Usuarios updateUsuario(Usuarios updateUsuario) {
		return this.jpa.save(updateUsuario);
	}

	@Override
	public Usuarios findIdUsuario(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<Usuarios> listUsuarios() {
		return this.jpa.findAll();
	}
}
