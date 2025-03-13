package co.edu.ue.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.ImagenesLibros;
import co.edu.ue.entity.Libros;

public interface IImagenesLibrosJPA extends JpaRepository<ImagenesLibros, Integer> {
  public ImagenesLibros findByLibro(Libros libro);

}
