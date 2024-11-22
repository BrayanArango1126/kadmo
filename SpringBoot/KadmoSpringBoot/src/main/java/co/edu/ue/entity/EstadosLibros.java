package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the estadoslibros database table.
 * 
 */
@Entity
@Table(name="estadoslibros")
@NamedQuery(name="EstadosLibros.findAll", query="SELECT e FROM EstadosLibros e")
public class EstadosLibros implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idEstadosLibros")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstadosLibros;
	
	
	@NotNull(message = "El campo de estados de libros no se envió")
	@NotBlank(message = "El campo de estados de libros no puede estar vacio")
	@Column(name="estado")
	private String estado;

	//bi-directional many-to-one association to Libros
	@OneToMany(mappedBy="estadoslibro")
	@JsonBackReference("estados-libros")
	private List<Libros> libros;

	public EstadosLibros() {
	}

	public int getIdEstadosLibros() {
		return this.idEstadosLibros;
	}

	public void setIdEstadosLibros(int idEstadosLibros) {
		this.idEstadosLibros = idEstadosLibros;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Libros> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libros> libros) {
		this.libros = libros;
	}

	public Libros addLibro(Libros libro) {
		getLibros().add(libro);
		libro.setEstadoslibro(this);

		return libro;
	}

	public Libros removeLibro(Libros libro) {
		getLibros().remove(libro);
		libro.setEstadoslibro(null);

		return libro;
	}

}