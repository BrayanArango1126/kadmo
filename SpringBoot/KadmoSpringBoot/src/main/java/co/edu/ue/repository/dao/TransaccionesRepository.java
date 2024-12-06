package co.edu.ue.repository.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Transacciones;
import co.edu.ue.repository.jpa.ITransaccionesJPA;

@Repository
public class TransaccionesRepository implements ITransaccionesRepository {

	@Autowired
	ITransaccionesJPA jpa;

	@Override
	public Transacciones insertTransacciones(Transacciones newTransacciones) {
		return this.jpa.save(newTransacciones);
	}

	@Override
	public Transacciones updateTransacciones(Transacciones updateTransacciones) {
		return this.jpa.save(updateTransacciones);
	}

	@Override
	public Transacciones findIdTransacciones(int id) {
		return this.jpa.findById(id).orElse(null);
	}

	@Override
	public List<Transacciones> listTransacciones() {
		return this.jpa.findAll();
	}

	@Override
	public List<Transacciones> obtenerTransaccionesPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
		return jpa.findByFechaBetween(fechaInicio, fechaFin);
	}

}
