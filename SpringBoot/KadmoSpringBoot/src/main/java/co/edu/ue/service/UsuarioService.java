package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.UsuariosDTO;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.IUsuarioRepository;

@Service
public class UsuarioService  implements IUsuarioService{
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IUsuarioRepository dao;

	@Override
	public UsuariosDTO addUsuario(Usuarios newUsuario) {
		Usuarios newUser = this.dao.insertUsuario(newUsuario);
		UsuariosDTO usuarioDTO = modelMapper.map(newUser, UsuariosDTO.class); 
		return usuarioDTO;
	}

	@Override
	public UsuariosDTO updUsuario(Usuarios updateUsuario) {
		Usuarios updateUser = this.dao.updateUsuario(updateUsuario);
		UsuariosDTO usuarioDTO = modelMapper.map(updateUser, UsuariosDTO.class); 
		return usuarioDTO;
	}

	@Override
	public UsuariosDTO findIdUsuario(int id) {
		Usuarios usuarioId = this.dao.findIdUsuario(id);
		UsuariosDTO usuarioDTO = modelMapper.map(usuarioId, UsuariosDTO.class);
		return usuarioDTO;
	}

	@Override
	public List<UsuariosDTO> listAllUsuarios() {
		List<Usuarios> listUser = this.dao.listUsuarios();
		return listUser.stream().map(user -> modelMapper.map(user, UsuariosDTO.class)).collect(Collectors.toList());
	}
	
	
}
