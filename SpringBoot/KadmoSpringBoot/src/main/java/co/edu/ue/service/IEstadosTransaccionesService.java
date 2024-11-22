package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.EstadosTransaccionesDTO;
import co.edu.ue.entity.EstadosTransacciones;

public interface IEstadosTransaccionesService {

	EstadosTransaccionesDTO addEstadosTransacciones(EstadosTransacciones newEstadosTransacciones);
	EstadosTransaccionesDTO upEstadosTransacciones(EstadosTransacciones updateEstadosTransacciones);
	EstadosTransaccionesDTO findIdEstadosTransacciones(int id);
	List<EstadosTransaccionesDTO> listAllEstadosTransacciones();
}
