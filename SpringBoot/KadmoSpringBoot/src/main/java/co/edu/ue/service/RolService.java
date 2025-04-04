package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.RolDTO;
import co.edu.ue.entity.Roles;
import co.edu.ue.repository.dao.IRolRepository;

@Service
public class RolService implements IRolService{
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IRolRepository dao;

	@Override
	public RolDTO addRol(Roles newRol) {
		Roles addedRol = this.dao.insertRol(newRol);
		RolDTO rolDTO = modelMapper.map(addedRol, RolDTO.class);
		return rolDTO;
	}

	@Override
	public RolDTO updRol(Roles updateRol) {
		Roles updatedRol = this.dao.updateRol(updateRol);
		RolDTO rolDTO = modelMapper.map(updatedRol, RolDTO.class);
		return rolDTO;
	}

	@Override
	public RolDTO findIdRol(int id) {
		Roles rol = dao.findIdRol(id);
		RolDTO rolDTO = modelMapper.map(rol, RolDTO.class);
		return rolDTO;
	}

	@Override
	public List<RolDTO> listAllRoles() {
		List<Roles> listRol = dao.listRoles();
		return listRol.stream().map(rol -> modelMapper.map(rol, RolDTO.class)).collect(Collectors.toList());
	}
}
