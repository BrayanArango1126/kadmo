package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the categoriaslibros database table.
 * 
 */
@Entity
@Table(name="categoriaslibros")
@NamedQuery(name="CategoriasLibros.findAll", query="SELECT c FROM CategoriasLibros c")
public class CategoriasLibros implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idCategoriaLibro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategoriaLibro;

	@Column(name="categoria")
	private String categoria;

	//bi-directional many-to-one association to Libros
	@OneToMany(mappedBy="categoriaslibro")
	@JsonBackReference("categorias-libros")
	private List<Libros> libros;

	public CategoriasLibros() {
	}

	public int getIdCategoriaLibro() {
		return this.idCategoriaLibro;
	}

	public void setIdCategoriaLibro(int idCategoriaLibro) {
		this.idCategoriaLibro = idCategoriaLibro;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Libros> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libros> libros) {
		this.libros = libros;
	}

	public Libros addLibro(Libros libro) {
		getLibros().add(libro);
		libro.setCategoriaslibro(this);

		return libro;
	}

	public Libros removeLibro(Libros libro) {
		getLibros().remove(libro);
		libro.setCategoriaslibro(null);

		return libro;
	}

}