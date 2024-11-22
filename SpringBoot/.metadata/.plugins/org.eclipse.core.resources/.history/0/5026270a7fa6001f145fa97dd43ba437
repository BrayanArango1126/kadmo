package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Roles;
import co.edu.ue.repository.dao.IRolRepository;

@Service
public class RolService implements IRolService{

	@Autowired
	IRolRepository dao;

	@Override
	public Roles addRol(Roles newRol) {
		return this.dao.insertRol(newRol);
	}

	@Override
	public Roles updRol(Roles updateRol) {
		return this.dao.updateRol(updateRol);
	}

	@Override
	public Roles findIdRol(int id) {
		return this.dao.findIdRol(id);
	}

	@Override
	public List<Roles> listAllRoles() {
		return this.dao.listRoles();
	}
}
