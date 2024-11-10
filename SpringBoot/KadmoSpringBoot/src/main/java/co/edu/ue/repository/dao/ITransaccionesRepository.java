package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Transacciones;

public interface ITransaccionesRepository {

	Transacciones insertTransacciones(Transacciones newTransacciones);
	Transacciones updateTransacciones(Transacciones updateTransacciones);
	Transacciones findIdTransacciones(int id);
	List<Transacciones> listTransacciones();
}
