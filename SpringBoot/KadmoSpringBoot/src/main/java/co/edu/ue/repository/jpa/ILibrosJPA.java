package co.edu.ue.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import co.edu.ue.entity.Libros;

public interface ILibrosJPA extends JpaRepository<Libros, Integer>, JpaSpecificationExecutor<Libros> {

}
