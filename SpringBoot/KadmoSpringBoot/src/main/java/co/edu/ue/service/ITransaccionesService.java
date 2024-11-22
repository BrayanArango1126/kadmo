package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.TransaccionesDTO;
import co.edu.ue.entity.Transacciones;

public interface ITransaccionesService {

	TransaccionesDTO addTransacciones(Transacciones newTransacciones);
	TransaccionesDTO upTransacciones(Transacciones updateTransacciones);
	TransaccionesDTO findIdTransacciones(int id);
	List<TransaccionesDTO> listAllTransacciones();
}
