package co.edu.ue.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Calificaciones;
import co.edu.ue.entity.Libros;

public interface ICalificacionesJPA extends JpaRepository<Calificaciones, Integer> {

    List<Calificaciones> findByLibro(Libros idLibro);
}
