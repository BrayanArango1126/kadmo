package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the libros database table.
 * 
 */
@Entity
@Table(name="libros")
@NamedQuery(name="Libros.findAll", query="SELECT l FROM Libros l")
public class Libros implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idLibros")
	private int idLibros;

	@Column(name="autor")
	private String autor;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="fechaModificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;

	@Column(name="nombre")
	private String nombre;

	@Column(name="precio")
	private double precio;

	//bi-directional many-to-one association to Calificaciones
	@OneToMany(mappedBy="libro")
	@JsonBackReference("libros-calificaciones")
	private List<Calificaciones> calificaciones;

	//bi-directional many-to-one association to ImagenesLibros
	@OneToMany(mappedBy="libro")
	@JsonBackReference("libros-imagenes")
	private List<ImagenesLibros> imageneslibros;

	//bi-directional many-to-one association to CategoriasLibros
	@ManyToOne
	@JoinColumn(name="idCategoriaLibro")
	private CategoriasLibros categoriaslibro;

	//bi-directional many-to-one association to DisponibilidadLibros
	@ManyToOne
	@JoinColumn(name="idDisponibilidadLibro")
	private DisponibilidadLibros disponibilidadlibro;

	//bi-directional many-to-one association to EstadosLibros
	@ManyToOne
	@JoinColumn(name="idEstadosLibros")
	private EstadosLibros estadoslibro;

	//bi-directional many-to-one association to LibrosFavoritos
	@OneToMany(mappedBy="libro")
	@JsonBackReference("libros-favoritos")
	private List<LibrosFavoritos> librosfavoritos;

	//bi-directional many-to-one association to LibrosPublicados
	@OneToMany(mappedBy="libro")
	@JsonBackReference("libros-publicados")
	private List<LibrosPublicados> librospublicados;

	//bi-directional many-to-one association to Transacciones
	@OneToMany(mappedBy="libro")
	@JsonBackReference("libros-transacciones")
	private List<Transacciones> transacciones;

	public Libros() {
	}

	public int getIdLibros() {
		return this.idLibros;
	}

	public void setIdLibros(int idLibros) {
		this.idLibros = idLibros;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Calificaciones> getCalificaciones() {
		return this.calificaciones;
	}

	public void setCalificaciones(List<Calificaciones> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Calificaciones addCalificacione(Calificaciones calificacione) {
		getCalificaciones().add(calificacione);
		calificacione.setLibro(this);

		return calificacione;
	}

	public Calificaciones removeCalificacione(Calificaciones calificacione) {
		getCalificaciones().remove(calificacione);
		calificacione.setLibro(null);

		return calificacione;
	}

	public List<ImagenesLibros> getImageneslibros() {
		return this.imageneslibros;
	}

	public void setImageneslibros(List<ImagenesLibros> imageneslibros) {
		this.imageneslibros = imageneslibros;
	}

	public ImagenesLibros addImageneslibro(ImagenesLibros imageneslibro) {
		getImageneslibros().add(imageneslibro);
		imageneslibro.setLibro(this);

		return imageneslibro;
	}

	public ImagenesLibros removeImageneslibro(ImagenesLibros imageneslibro) {
		getImageneslibros().remove(imageneslibro);
		imageneslibro.setLibro(null);

		return imageneslibro;
	}

	public CategoriasLibros getCategoriaslibro() {
		return this.categoriaslibro;
	}

	public void setCategoriaslibro(CategoriasLibros categoriaslibro) {
		this.categoriaslibro = categoriaslibro;
	}

	public DisponibilidadLibros getDisponibilidadlibro() {
		return this.disponibilidadlibro;
	}

	public void setDisponibilidadlibro(DisponibilidadLibros disponibilidadlibro) {
		this.disponibilidadlibro = disponibilidadlibro;
	}

	public EstadosLibros getEstadoslibro() {
		return this.estadoslibro;
	}

	public void setEstadoslibro(EstadosLibros estadoslibro) {
		this.estadoslibro = estadoslibro;
	}

	public List<LibrosFavoritos> getLibrosfavoritos() {
		return this.librosfavoritos;
	}

	public void setLibrosfavoritos(List<LibrosFavoritos> librosfavoritos) {
		this.librosfavoritos = librosfavoritos;
	}

	public LibrosFavoritos addLibrosfavorito(LibrosFavoritos librosfavorito) {
		getLibrosfavoritos().add(librosfavorito);
		librosfavorito.setLibro(this);

		return librosfavorito;
	}

	public LibrosFavoritos removeLibrosfavorito(LibrosFavoritos librosfavorito) {
		getLibrosfavoritos().remove(librosfavorito);
		librosfavorito.setLibro(null);

		return librosfavorito;
	}

	public List<LibrosPublicados> getLibrospublicados() {
		return this.librospublicados;
	}

	public void setLibrospublicados(List<LibrosPublicados> librospublicados) {
		this.librospublicados = librospublicados;
	}

	public LibrosPublicados addLibrospublicado(LibrosPublicados librospublicado) {
		getLibrospublicados().add(librospublicado);
		librospublicado.setLibro(this);

		return librospublicado;
	}

	public LibrosPublicados removeLibrospublicado(LibrosPublicados librospublicado) {
		getLibrospublicados().remove(librospublicado);
		librospublicado.setLibro(null);

		return librospublicado;
	}

	public List<Transacciones> getTransacciones() {
		return this.transacciones;
	}

	public void setTransacciones(List<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

	public Transacciones addTransaccione(Transacciones transaccione) {
		getTransacciones().add(transaccione);
		transaccione.setLibro(this);

		return transaccione;
	}

	public Transacciones removeTransaccione(Transacciones transaccione) {
		getTransacciones().remove(transaccione);
		transaccione.setLibro(null);

		return transaccione;
	}

}