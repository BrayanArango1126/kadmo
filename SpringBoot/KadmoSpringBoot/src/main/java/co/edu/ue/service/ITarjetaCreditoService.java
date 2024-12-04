package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dto.TarjetaCreditoDTO;
import co.edu.ue.entity.TarjetaCredito;
import co.edu.ue.entity.Usuarios;

public interface ITarjetaCreditoService {
  TarjetaCreditoDTO addTarjetaCredito(TarjetaCredito newTarjetaCredito);

  TarjetaCreditoDTO updTarjetaCredito(TarjetaCredito updateTarjetaCredito);

  TarjetaCreditoDTO findIdTarjetaCredito(int id);

  List<TarjetaCreditoDTO> listAllTarjetaCredito();

  List<TarjetaCreditoDTO> findByUsuario(Usuarios idUsuario);
}
