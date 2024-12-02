package co.edu.ue.entity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

import co.edu.ue.dto.CategoriasLibrosDTO;
import co.edu.ue.dto.LibrosFiltrosDTO;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;

public class LibroSpecification {
  public static Specification<Libros> conFiltros(LibrosFiltrosDTO filtros) {
    return (root, query, criteriaBuilder) -> {
      Predicate predicate = criteriaBuilder.conjunction(); // Inicializamos con un AND vacío

      if (filtros.getAutor() != null) {
        predicate = criteriaBuilder.and(predicate,
            criteriaBuilder.equal(root.get("autor"), filtros.getAutor()));
      }

      // if (filtros.getCategoriasLibro() != null) {
      // Join<Libros, CategoriasLibros> categoriaJoin = root.join("categoriaslibro");
      // // Realiza el join con la relación
      // predicate = criteriaBuilder.and(predicate,
      // criteriaBuilder.equal(categoriaJoin.get("idCategoriaLibro"),
      // filtros.getCategoriasLibro().getIdCategoriaLibro()));
      // }

      if (filtros.getDisponibilidadLibro() != null) {
        Join<Libros, DisponibilidadLibros> disponibilidadJoin = root.join("disponibilidadlibro");
        // Realiza el join con la relación
        predicate = criteriaBuilder.and(predicate,
            criteriaBuilder.equal(disponibilidadJoin.get("idDisponibilidadLibro"),
                filtros.getDisponibilidadLibro().getIdDisponibilidadLibro()));
      }

      if (filtros.getEstadosLibro() != null) {
        Join<Libros, EstadosLibros> estadoJoin = root.join("estadoslibro");
        // Realiza el join con la relación
        predicate = criteriaBuilder.and(predicate,
            criteriaBuilder.equal(estadoJoin.get("idEstadosLibros"), filtros.getEstadosLibro().getIdEstadosLibros()));
      }

      if (filtros.getCategoriasLibro() != null && !filtros.getCategoriasLibro().isEmpty()) {
        Join<Libros, CategoriasLibros> categoriaJoin = root.join("categoriaslibro");
        List<Integer> idsCategorias = filtros.getCategoriasLibro().stream()
            .map(CategoriasLibrosDTO::getIdCategoriaLibro)
            .collect(Collectors.toList());

        predicate = criteriaBuilder.and(predicate, categoriaJoin.get("idCategoriaLibro").in(idsCategorias));
      }

      if (filtros.getPrecio() != null) {
        predicate = criteriaBuilder.and(predicate,
            criteriaBuilder.equal(root.get("precio"), filtros.getPrecio()));
      }
      return predicate;
    };
  }
}
