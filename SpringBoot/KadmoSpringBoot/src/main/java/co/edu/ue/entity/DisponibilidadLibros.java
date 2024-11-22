package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the disponibilidadlibros database table.
 * 
 */
@Entity
@Table(name="disponibilidadlibros")
@NamedQuery(name="DisponibilidadLibros.findAll", query="SELECT d FROM DisponibilidadLibros d")
public class DisponibilidadLibros implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idDisponibilidadLibro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDisponibilidadLibro;
	
	
	@NotNull(message = "El campo de disponibilidad no se envió")
	@NotBlank(message = "El campo de disponibilidad no puede estar vacio")
	@Column(name="disponibilidad")
	private String disponibilidad;

	//bi-directional many-to-one association to Libros
	@OneToMany(mappedBy="disponibilidadlibro")
	@JsonBackReference("disponibilidad-libros")
	private List<Libros> libros;

	public DisponibilidadLibros() {
	}

	public int getIdDisponibilidadLibro() {
		return this.idDisponibilidadLibro;
	}

	public void setIdDisponibilidadLibro(int idDisponibilidadLibro) {
		this.idDisponibilidadLibro = idDisponibilidadLibro;
	}

	public String getDisponibilidad() {
		return this.disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public List<Libros> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libros> libros) {
		this.libros = libros;
	}

	public Libros addLibro(Libros libro) {
		getLibros().add(libro);
		libro.setDisponibilidadlibro(this);

		return libro;
	}

	public Libros removeLibro(Libros libro) {
		getLibros().remove(libro);
		libro.setDisponibilidadlibro(null);

		return libro;
	}

}