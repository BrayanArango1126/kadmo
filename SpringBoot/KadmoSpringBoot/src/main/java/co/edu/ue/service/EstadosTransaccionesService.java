package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.EstadosTransaccionesDTO;
import co.edu.ue.entity.EstadosTransacciones;
import co.edu.ue.repository.dao.IEstadosTransaccionesRepository;

@Service
public class EstadosTransaccionesService implements IEstadosTransaccionesService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	IEstadosTransaccionesRepository dao;

	@Override
	public EstadosTransaccionesDTO addEstadosTransacciones(EstadosTransacciones newEstadosTransacciones) {
		EstadosTransacciones addEstado = this.dao.insertEstadosTransacciones(newEstadosTransacciones);
		EstadosTransaccionesDTO estadoTransaccionDTO = this.modelMapper.map(addEstado, EstadosTransaccionesDTO.class);
		return estadoTransaccionDTO;
	}

	@Override
	public EstadosTransaccionesDTO upEstadosTransacciones(EstadosTransacciones updateEstadosTransacciones) {
		EstadosTransacciones upEstado = this.dao.updateEstadosTransacciones(updateEstadosTransacciones);
		EstadosTransaccionesDTO estadoTransaccionDTO = this.modelMapper.map(upEstado, EstadosTransaccionesDTO.class);
		return estadoTransaccionDTO;
	}

	@Override
	public EstadosTransaccionesDTO findIdEstadosTransacciones(int id) {
		EstadosTransacciones idEstado = this.dao.findIdEstadosTransacciones(id);
		EstadosTransaccionesDTO estadoTransaccionDTO = this.modelMapper.map(idEstado, EstadosTransaccionesDTO.class);
		return estadoTransaccionDTO;
	}

	@Override
	public List<EstadosTransaccionesDTO> listAllEstadosTransacciones() {
		List<EstadosTransacciones> listAllEstados = this.dao.listEstadosTransacciones();
		return listAllEstados.stream().map(estado -> this.modelMapper.map(estado, EstadosTransaccionesDTO.class)).collect(Collectors.toList());
	}

	

	
	
	
}
