package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.DatosUsuarios;
import co.edu.ue.repository.dao.IDatoUsuarioRepository;

@Service
public class DatoUsuarioService implements IDatoUsuarioService{

	@Autowired
	IDatoUsuarioRepository dao;

	@Override
	public DatosUsuarios addDatoUsuario(DatosUsuarios newDatoUsuario) {
		return this.dao.insertDatoUsuario(newDatoUsuario);
	}

	@Override
	public DatosUsuarios updDatoUsuario(DatosUsuarios updateDatoUsuario) {
		return this.dao.updateDatoUsuario(updateDatoUsuario);
	}

	@Override
	public DatosUsuarios findIdDatoUsuario(int id) {
		return this.dao.findIdDatoUsuario(id);
	}

	@Override
	public List<DatosUsuarios> listAllDatosUsuarios() {
		return this.dao.listDatosUsuarios();
	}
	
	
}
