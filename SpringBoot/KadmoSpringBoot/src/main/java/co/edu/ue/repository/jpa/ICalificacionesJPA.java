package co.edu.ue.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ue.dto.CalificacionesLibroDTO;
import co.edu.ue.entity.Calificaciones;
// import co.edu.ue.entity.Libros;
import co.edu.ue.entity.Libros;

public interface ICalificacionesJPA extends JpaRepository<Calificaciones, Integer> {

    List<Calificaciones> findByLibro(Libros idLibro);

    @Query(value = "SELECT c.idCalificacion, c.idLibro, l.nombre AS nombreLibro, c.comentario, c.fechaCalificacion, l.autor AS autorLibro, " +
        "l.precio AS precioLibro, l.descripcion AS descripcionLibro, u.idUsuario, du.nombres, du.apellidos " +
        "FROM calificaciones c " +
        "INNER JOIN usuarios u ON u.idUsuario = c.idUsuario " +
        "INNER JOIN datosusuarios du ON du.idUsuario = u.idUsuario " +
        "INNER JOIN libros l ON l.idLibros = c.idLibro " +
        "WHERE c.idLibro = :idLibro",
        nativeQuery = true)
    List<CalificacionesLibroDTO> findCalificacionDetalles(int idLibro);
}
