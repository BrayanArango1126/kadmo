package co.edu.ue.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.TransaccionesDTO;
import co.edu.ue.entity.Transacciones;
import co.edu.ue.repository.dao.ITransaccionesRepository;

@Service
public class TransaccionesService implements ITransaccionesService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ITransaccionesRepository dao;

	@Override
	public TransaccionesDTO addTransacciones(Transacciones newTransacciones) {
		Transacciones addTransaccion = this.dao.insertTransacciones(newTransacciones);
		TransaccionesDTO transaccionDTO = this.modelMapper.map(addTransaccion, TransaccionesDTO.class);
		return transaccionDTO;
	}

	@Override
	public TransaccionesDTO upTransacciones(Transacciones updateTransacciones) {
		Transacciones updTransaccion = this.dao.updateTransacciones(updateTransacciones);
		TransaccionesDTO transaccionDTO = this.modelMapper.map(updTransaccion, TransaccionesDTO.class);
		return transaccionDTO;
	}

	@Override
	public TransaccionesDTO findIdTransacciones(int id) {
		Transacciones idTransaccion = this.dao.findIdTransacciones(id);
		TransaccionesDTO transaccionDTO = this.modelMapper.map(idTransaccion, TransaccionesDTO.class);
		return transaccionDTO;
	}

	@Override
	public List<TransaccionesDTO> listAllTransacciones() {
		List<Transacciones> listAllTransacciones = this.dao.listTransacciones();
		return listAllTransacciones.stream().map(transac -> this.modelMapper.map(transac, TransaccionesDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ByteArrayInputStream generarReporteExcel(LocalDate fechaInicio, LocalDate fechaFin) throws IOException {
		List<Transacciones> transacciones = this.dao.obtenerTransaccionesPorFecha(fechaInicio, fechaFin);

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			Sheet sheet = workbook.createSheet("Transacciones");

			// Crear encabezados
			Row headerRow = sheet.createRow(0);
			String[] columnas = { "ID Transacción", "Libro", "Autor", "Precio", "Estado del Libro", "Categoría", "ID Usuario",
					"Correo", "Total", "Estado de Transacción", "Fecha Transacción" };
			for (int i = 0; i < columnas.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columnas[i]);
				CellStyle headerStyle = workbook.createCellStyle();
				headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
				headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				cell.setCellStyle(headerStyle);
			}

			// Llenar datos
			int rowIdx = 1;
			for (Transacciones transaccion : transacciones) {
				Row row = sheet.createRow(rowIdx++);
				row.createCell(0).setCellValue(transaccion.getIdTransaccion());
				row.createCell(1).setCellValue(transaccion.getLibro().getNombre());
				row.createCell(2).setCellValue(transaccion.getLibro().getAutor());
				row.createCell(3).setCellValue(transaccion.getLibro().getPrecio());
				row.createCell(4).setCellValue(transaccion.getLibro().getEstadoslibro().getEstado());
				row.createCell(5).setCellValue(transaccion.getLibro().getCategoriaslibro().getCategoria());
				row.createCell(6).setCellValue(transaccion.getUsuario().getIdUsuario());
				row.createCell(7).setCellValue(transaccion.getUsuario().getCorreo());
				row.createCell(8).setCellValue(transaccion.getTotal().toString());
				row.createCell(9).setCellValue(transaccion.getEstadostransaccione().getEstado());
				row.createCell(10).setCellValue(transaccion.getFechaTransaccion().toString());
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

}
