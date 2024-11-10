package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.EstadosTransacciones;

public interface IEstadosTransaccionesRepository {

	EstadosTransacciones insertEstadosTransacciones(EstadosTransacciones newEstadosTransacciones);
	EstadosTransacciones updateEstadosTransacciones(EstadosTransacciones updateEstadosTransacciones);
	EstadosTransacciones findIdEstadosTransacciones(int id);
	List<EstadosTransacciones> listEstadosTransacciones();
}
