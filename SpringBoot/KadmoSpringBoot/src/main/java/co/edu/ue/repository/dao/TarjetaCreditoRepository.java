package co.edu.ue.repository.dao;

import java.util.List;

import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.TarjetaCredito;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.jpa.ITarjetaCreditoJPA;

@Repository
public class TarjetaCreditoRepository implements ITarjetaCreditoRepository {

  @Autowired
  ITarjetaCreditoJPA jpa;

  @Override
  public TarjetaCredito insertTarjetaCredito(TarjetaCredito newTarjetaCredito) {
    return this.jpa.save(newTarjetaCredito);
  }

  @Override
  public TarjetaCredito updateTarjetaCredito(TarjetaCredito updateTarjetaCredito) {
    return this.jpa.save(updateTarjetaCredito);
  }

  @Override
  public TarjetaCredito findIdTarjetaCredito(int id) {
    return this.jpa.findById(id).orElse(null);
  }

  @Override
  public List<TarjetaCredito> listTarjetaCredito() {
    return this.jpa.findAll();
  }

  @Override
  public List<TarjetaCredito> findByUsuario(Usuarios idUsuario) {
    return this.jpa.findByUsuario(idUsuario);
  }

}
