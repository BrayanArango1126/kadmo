package co.edu.ue.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import co.edu.ue.dto.TransaccionesDTO;
import co.edu.ue.entity.Transacciones;

public interface ITransaccionesService {

	TransaccionesDTO addTransacciones(Transacciones newTransacciones);

	TransaccionesDTO upTransacciones(Transacciones updateTransacciones);

	TransaccionesDTO findIdTransacciones(int id);

	List<TransaccionesDTO> listAllTransacciones();

	ByteArrayInputStream generarReporteExcel(LocalDate fechaInicio, LocalDate fechaFin) throws IOException;
}
