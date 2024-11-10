package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Roles;

public interface IRolRepository {

	Roles insertRol(Roles newRol);
	Roles updateRol(Roles updateRol);
	Roles findIdRol(int id);
	List<Roles> listRoles();
}
