package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Transacciones;
import co.edu.ue.repository.dao.ITransaccionesRepository;

@Service
public class TransaccionesService implements ITransaccionesService{

	@Autowired
	ITransaccionesRepository dao;

	@Override
	public Transacciones addTransacciones(Transacciones newTransacciones) {
		return this.dao.insertTransacciones(newTransacciones);
	}

	@Override
	public Transacciones upTransacciones(Transacciones updateTransacciones) {
		return this.dao.updateTransacciones(updateTransacciones);
	}

	@Override
	public Transacciones findIdTransacciones(int id) {
		return this.dao.findIdTransacciones(id);
	}

	@Override
	public List<Transacciones> listAllTransacciones() {
		return this.dao.listTransacciones();
	}
	
	
}
