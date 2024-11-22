package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.TransaccionesDTO;
import co.edu.ue.entity.Transacciones;
import co.edu.ue.repository.dao.ITransaccionesRepository;

@Service
public class TransaccionesService implements ITransaccionesService{

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
		return listAllTransacciones.stream().map(transac -> this.modelMapper.map(transac, TransaccionesDTO.class)).collect(Collectors.toList());
	}
	
	
}
