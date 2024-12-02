package co.edu.ue.dto;

import java.util.List;

public class LibrosFiltrosDTO {
  private String autor;
  private DisponibilidadLibrosDTO disponibilidadLibro;
  private List<CategoriasLibrosDTO> categoriasLibro;
  private EstadosLibrosDTO estadosLibro;
  private Double precio;

  public LibrosFiltrosDTO(DisponibilidadLibrosDTO disponibilidad, String autor, List<CategoriasLibrosDTO> categoria,
      Double precio,
      EstadosLibrosDTO estado) {
    this.disponibilidadLibro = disponibilidad;
    this.autor = autor;
    this.categoriasLibro = categoria;
    this.precio = precio;
    this.estadosLibro = estado;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public DisponibilidadLibrosDTO getDisponibilidadLibro() {
    return disponibilidadLibro;
  }

  public void setDisponibilidadLibro(DisponibilidadLibrosDTO disponibilidadLibro) {
    this.disponibilidadLibro = disponibilidadLibro;
  }

  public List<CategoriasLibrosDTO> getCategoriasLibro() {
    return categoriasLibro;
  }

  public void setCategoriasLibro(List<CategoriasLibrosDTO> categoriasLibro) {
    this.categoriasLibro = categoriasLibro;
  }

  public Double getPrecio() {
    return precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public EstadosLibrosDTO getEstadosLibro() {
    return estadosLibro;
  }

  public void setEstadosLibro(EstadosLibrosDTO estadosLibro) {
    this.estadosLibro = estadosLibro;
  }

  @Override
  public String toString() {
    return "LibrosFiltrosDTO{" +
        "disponibilidad='" + disponibilidadLibro + '\'' +
        ", autor='" + autor + '\'' +
        ", categoria='" + categoriasLibro + '\'' +
        ", precio=" + precio +
        ", estado='" + estadosLibro + '\'' +
        '}';
  }
}
