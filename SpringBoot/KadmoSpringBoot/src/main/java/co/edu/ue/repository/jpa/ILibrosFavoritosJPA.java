package co.edu.ue.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.LibrosFavoritos;
import co.edu.ue.entity.Usuarios;

public interface ILibrosFavoritosJPA extends JpaRepository<LibrosFavoritos, Integer> {

  List<LibrosFavoritos> findByUsuario(Usuarios usuario);
}
