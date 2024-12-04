package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.TarjetaCredito;
import co.edu.ue.entity.Usuarios;

public interface ITarjetaCreditoRepository {
  TarjetaCredito insertTarjetaCredito(TarjetaCredito newTarjetaCredito);

  TarjetaCredito updateTarjetaCredito(TarjetaCredito updateTarjetaCredito);

  TarjetaCredito findIdTarjetaCredito(int id);

  List<TarjetaCredito> listTarjetaCredito();

  List<TarjetaCredito> findByUsuario(Usuarios idUsuario);
}
