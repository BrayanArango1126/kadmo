package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.TarjetaCreditoDTO;
import co.edu.ue.entity.TarjetaCredito;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.ITarjetaCreditoRepository;

@Service
public class TarjetaCreditoService implements ITarjetaCreditoService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  ITarjetaCreditoRepository dao;

  @Override
  public TarjetaCreditoDTO addTarjetaCredito(TarjetaCredito newTarjetaCredito) {
    TarjetaCredito tarjetaCredito = this.dao.insertTarjetaCredito(newTarjetaCredito);
    TarjetaCreditoDTO tarjetaCreditoDTO = this.modelMapper.map(tarjetaCredito, TarjetaCreditoDTO.class);
    return tarjetaCreditoDTO;
  }

  @Override
  public TarjetaCreditoDTO updTarjetaCredito(TarjetaCredito updateTarjetaCredito) {
    TarjetaCredito tarjetaCredito = this.dao.updateTarjetaCredito(updateTarjetaCredito);
    TarjetaCreditoDTO tarjetaCreditoDTO = this.modelMapper.map(tarjetaCredito, TarjetaCreditoDTO.class);
    return tarjetaCreditoDTO;
  }

  @Override
  public TarjetaCreditoDTO findIdTarjetaCredito(int id) {
    TarjetaCredito tarjetaCredito = this.dao.findIdTarjetaCredito(id);
    TarjetaCreditoDTO tarjetaCreditoDTO = this.modelMapper.map(tarjetaCredito, TarjetaCreditoDTO.class);
    return tarjetaCreditoDTO;
  }

  @Override
  public List<TarjetaCreditoDTO> listAllTarjetaCredito() {
    List<TarjetaCredito> tarjetaCreditoList = this.dao.listTarjetaCredito();
    return tarjetaCreditoList.stream()
        .map(tarjetaCredito -> this.modelMapper.map(tarjetaCredito, TarjetaCreditoDTO.class))
        .collect(Collectors.toList());

  }

  @Override
  public List<TarjetaCreditoDTO> findByUsuario(Usuarios idUsuario) {
    List<TarjetaCredito> tarjetaCreditoList = this.dao.findByUsuario(idUsuario);
    return tarjetaCreditoList.stream()
        .map(tarjetaCredito -> this.modelMapper.map(tarjetaCredito, TarjetaCreditoDTO.class))
        .collect(Collectors.toList());
  }

}
