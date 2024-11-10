package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.EstadosTransacciones;
import co.edu.ue.repository.jpa.IEstadosTransaccionesJPA;

@Repository
public class EstadosTransaccionesRepository implements IEstadosTransaccionesRepository{

	@Autowired
	IEstadosTransaccionesJPA jpa;

	@Override
	public EstadosTransacciones insertEstadosTransacciones(EstadosTransacciones newEstadosTransacciones) {
		return this.jpa.save(newEstadosTransacciones);
	}

	@Override
	public EstadosTransacciones updateEstadosTransacciones(EstadosTransacciones updateEstadosTransacciones) {
		return this.jpa.save(updateEstadosTransacciones);
	}

	@Override
	public EstadosTransacciones findIdEstadosTransacciones(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<EstadosTransacciones> listEstadosTransacciones() {
		return this.jpa.findAll();
	}
	
	
}
