package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the publicacionesautores database table.
 * 
 */
@Entity
@Table(name="publicacionesautores")
@NamedQuery(name="PublicacionesAutores.findAll", query="SELECT p FROM PublicacionesAutores p")
public class PublicacionesAutores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idPublicacionAutor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPublicacionAutor;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="fechaPublicacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPublicacion;

	@Column(name="titulo")
	private String titulo;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuarios usuario;

	public PublicacionesAutores() {
	}

	public int getIdPublicacionAutor() {
		return this.idPublicacionAutor;
	}

	public void setIdPublicacionAutor(int idPublicacionAutor) {
		this.idPublicacionAutor = idPublicacionAutor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}