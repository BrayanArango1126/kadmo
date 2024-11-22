package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.DatosUsuariosDTO;
import co.edu.ue.entity.DatosUsuarios;
import co.edu.ue.repository.dao.IDatoUsuarioRepository;

@Service
public class DatoUsuarioService implements IDatoUsuarioService{
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IDatoUsuarioRepository dao;

	@Override
	public DatosUsuariosDTO addDatoUsuario(DatosUsuarios newDatoUsuario) {
		DatosUsuarios newDatoUser = this.dao.insertDatoUsuario(newDatoUsuario);
		DatosUsuariosDTO datosUsuariosDTO = modelMapper.map(newDatoUser, DatosUsuariosDTO.class);
		return datosUsuariosDTO ;
	}

	@Override
	public DatosUsuariosDTO updDatoUsuario(DatosUsuarios updateDatoUsuario) {
		DatosUsuarios updateDatoUser = this.dao.updateDatoUsuario(updateDatoUsuario);
		DatosUsuariosDTO datosUsuariosDTO = modelMapper.map(updateDatoUser, DatosUsuariosDTO.class);
		return datosUsuariosDTO ;
	}

	@Override
	public DatosUsuariosDTO findIdDatoUsuario(int id) {
		DatosUsuarios datoUsuarioById = this.dao.findIdDatoUsuario(id);
		DatosUsuariosDTO datoUsuarioDTO = this.modelMapper.map(datoUsuarioById, DatosUsuariosDTO.class);
		return datoUsuarioDTO;
	}

	@Override
	public List<DatosUsuariosDTO> listAllDatosUsuarios() {
		List<DatosUsuarios> datosUsuariosList = this.dao.listDatosUsuarios();
		return datosUsuariosList.stream().map(dato -> modelMapper.map(dato, DatosUsuariosDTO.class)).collect(Collectors.toList());
	}
	
	
}
