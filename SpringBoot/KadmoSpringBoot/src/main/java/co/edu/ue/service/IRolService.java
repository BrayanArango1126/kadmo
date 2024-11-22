package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.RolDTO;
import co.edu.ue.entity.Roles;

public interface IRolService {

	RolDTO addRol(Roles newRol);
	RolDTO updRol(Roles updateRol);
	RolDTO findIdRol(int id);
	List<RolDTO> listAllRoles();
}
