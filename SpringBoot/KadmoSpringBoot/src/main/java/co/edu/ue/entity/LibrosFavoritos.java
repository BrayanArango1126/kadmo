package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the librosfavoritos database table.
 * 
 */
@Entity
@Table(name="librosfavoritos")
@NamedQuery(name="LibrosFavoritos.findAll", query="SELECT l FROM LibrosFavoritos l")
public class LibrosFavoritos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idLibroFavorito")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLibroFavorito;

	//bi-directional many-to-one association to Libros
	@ManyToOne
	@JoinColumn(name="idLibro")
	private Libros libro;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuarios usuario;

	public LibrosFavoritos() {
	}

	public int getIdLibroFavorito() {
		return this.idLibroFavorito;
	}

	public void setIdLibroFavorito(int idLibroFavorito) {
		this.idLibroFavorito = idLibroFavorito;
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