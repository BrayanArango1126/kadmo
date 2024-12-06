package co.edu.ue.repository.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.ue.entity.Transacciones;

public interface ITransaccionesJPA extends JpaRepository<Transacciones, Integer> {

  @Query("SELECT t FROM Transacciones t WHERE t.fechaTransaccion BETWEEN :fechaInicio AND :fechaFin")
  List<Transacciones> findByFechaBetween(@Param("fechaInicio") LocalDate fechaInicio,
      @Param("fechaFin") LocalDate fechaFin);
}
