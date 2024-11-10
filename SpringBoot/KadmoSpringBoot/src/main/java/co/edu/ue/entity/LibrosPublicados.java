package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the librospublicados database table.
 * 
 */
@Entity
@Table(name="librospublicados")
@NamedQuery(name="LibrosPublicados.findAll", query="SELECT l FROM LibrosPublicados l")
public class LibrosPublicados implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idLibrosPublicados")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLibrosPublicados;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPublicacion;

	//bi-directional many-to-one association to Libros
	@ManyToOne
	@JsonBackReference("publicados-libros")
	@JoinColumn(name="idLibro")
	private Libros libro;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	//@JsonBackReference("publicados-usuarios")
	@JoinColumn(name="idUsuario")
	private Usuarios usuario;

	public LibrosPublicados() {
	}

	public int getIdLibrosPublicados() {
		return this.idLibrosPublicados;
	}

	public void setIdLibrosPublicados(int idLibrosPublicados) {
		this.idLibrosPublicados = idLibrosPublicados;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
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