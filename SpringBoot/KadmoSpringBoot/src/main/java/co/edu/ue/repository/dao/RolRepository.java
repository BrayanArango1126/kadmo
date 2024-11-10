package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Roles;
import co.edu.ue.repository.jpa.IRolJPA;

@Repository
public class RolRepository implements IRolRepository{
	
	@Autowired
	IRolJPA jpa;

	@Override
	public Roles insertRol(Roles newRol) {	
		return this.jpa.save(newRol);
	}

	@Override
	public Roles updateRol(Roles updateRol) {
		return this.jpa.save(updateRol);
	
	}

	@Override
	public Roles findIdRol(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<Roles> listRoles() {
		return this.jpa.findAll();
	}

}
