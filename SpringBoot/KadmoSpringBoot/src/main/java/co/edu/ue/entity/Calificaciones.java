package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

/**
 * The persistent class for the calificaciones database table.
 * 
 */
@Entity
@Table(name = "calificaciones")
@NamedQuery(name = "Calificaciones.findAll", query = "SELECT c FROM Calificaciones c")
public class Calificaciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCalificacion")
	private int idCalificacion;

	@NotNull(message = "El campo de comentario no se envió")
	@NotBlank(message = "El campo de comentario no puede estar vacio")
	@Column(name = "comentario")
	private String comentario;

	@Column(name = "fechaCalificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCalificacion;

	@NotNull(message = "El campo puntuación es obligatorio")
	@Column(name = "puntuacion")
	private String puntuacion;

	// bi-directional many-to-one association to Libros
	@ManyToOne
	@JoinColumn(name = "idLibro")
	private Libros libro;

	// bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuarios usuario;

	public Calificaciones() {
	}

	public int getIdCalificacion() {
		return this.idCalificacion;
	}

	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaCalificacion() {
		return this.fechaCalificacion;
	}

	public void setFechaCalificacion(Date fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}

	public String getPuntuacion() {
		return this.puntuacion;
	}

	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Libros getLibro() {
		return this.libro;
	}

	public void setLibro(Libros libro) {
		this.libro = libro;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}