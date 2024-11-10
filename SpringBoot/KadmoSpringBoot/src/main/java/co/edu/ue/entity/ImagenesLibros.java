package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the imageneslibros database table.
 * 
 */
@Entity
@Table(name="imageneslibros")
@NamedQuery(name="ImagenesLibros.findAll", query="SELECT i FROM ImagenesLibros i")
public class ImagenesLibros implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idImagenLibro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idImagenLibro;

	@Column(name="url")
	private String url;
	
	@Column(name="fechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	//bi-directional many-to-one association to Libros
	@ManyToOne
	@JoinColumn(name="idLibro")
	private Libros libro;

	public ImagenesLibros() {
	}

	public int getIdImagenLibro() {
		return this.idImagenLibro;
	}

	public void setIdImagenLibro(int idImagenLibro) {
		this.idImagenLibro = idImagenLibro;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Libros getLibro() {
		return this.libro;
	}

	public void setLibro(Libros libro) {
		this.libro = libro;
	}

}