package co.edu.ue.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.TarjetaCredito;
import co.edu.ue.entity.Usuarios;

public interface ITarjetaCreditoJPA extends JpaRepository<TarjetaCredito, Integer> {

  List<TarjetaCredito> findByUsuario(Usuarios idUsuario);
}
