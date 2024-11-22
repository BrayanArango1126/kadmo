package co.edu.ue.dto;

public class LibrosDTO {

	private int idLibros;
	private String nombre;
	private String autor;
	private Double precio;
	private String descripcion;
	private EstadosLibrosDTO estadosLibro;
	private DisponibilidadLibrosDTO disponibilidadLibro;
	private CategoriasLibrosDTO categoriasLibro;
	
	public int getIdLibros() {
		return idLibros;
	}
	public void setIdLibros(int idLibros) {
		this.idLibros = idLibros;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public EstadosLibrosDTO getEstadosLibro() {
		return estadosLibro;
	}
	public void setEstadosLibro(EstadosLibrosDTO estadosLibro) {
		this.estadosLibro = estadosLibro;
	}
	public DisponibilidadLibrosDTO getDisponibilidadLibro() {
		return disponibilidadLibro;
	}
	public void setDisponibilidadLibro(DisponibilidadLibrosDTO disponibilidadLibro) {
		this.disponibilidadLibro = disponibilidadLibro;
	}
	public CategoriasLibrosDTO getCategoriasLibro() {
		return categoriasLibro;
	}
	public void setCategoriasLibro(CategoriasLibrosDTO categoriasLibro) {
		this.categoriasLibro = categoriasLibro;
	}

	
}
