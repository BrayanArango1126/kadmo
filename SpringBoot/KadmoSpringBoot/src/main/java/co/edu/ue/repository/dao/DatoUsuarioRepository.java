package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.DatosUsuarios;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.jpa.IDatoUsuarioJPA;

@Repository
public class DatoUsuarioRepository implements IDatoUsuarioRepository{

	@Autowired
	IDatoUsuarioJPA jpa;

	@Override
	public DatosUsuarios insertDatoUsuario(DatosUsuarios newDatoUsuario) {	
		return this.jpa.save(newDatoUsuario);
	}

	@Override
	public DatosUsuarios updateDatoUsuario(DatosUsuarios updateDatoUsuario) {
		return this.jpa.save(updateDatoUsuario);
	}

	@Override
	public DatosUsuarios findIdDatoUsuario(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<DatosUsuarios> listDatosUsuarios() {
		return this.jpa.findAll();
	}

	@Override
	public DatosUsuarios findByUsuario(Usuarios idUsuario) {
		return this.jpa.findByUsuario(idUsuario);
	}
	
}
