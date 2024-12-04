package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
public class Usuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idUsuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@NotNull(message = "El campo de contraseña no se envió")
	@NotBlank(message = "El campo de contraseña no puede estar vacio")
	// @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,15}$",
	// message = "Hay un error en la contraseña, recuerda tener al menos una letra
	// minúscula, mayúscula y numérica, y la longitud es de mínimo 8 y maximo 15
	// caracteres")
	@Column(name = "contraseña")
	private String contraseña;

	@NotNull(message = "El campo de correo no se envió")
	@NotBlank(message = "El campo de correo no puede estar vacio")
	@Pattern(regexp = "^[^\\s@]+@+(hotmail|gmail|outlook)\\.(com|co|edu\\.co)$", message = "Hay un error en la estructura de tu correo")
	@Column(name = "correo")
	private String correo;

	@Column(name = "fechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	// bi-directional many-to-one association to Calificaciones
	@OneToMany(mappedBy = "usuario")
	@JsonBackReference("usuario-calificaciones")
	private List<Calificaciones> calificaciones;

	// bi-directional many-to-one association to DatosUsuarios
	@OneToMany(mappedBy = "usuario")
	@JsonBackReference("usuario-datosusuarios")
	private List<DatosUsuarios> datosusuarios;

	// bi-directional many-to-one association to Editoriales
	@OneToMany(mappedBy = "usuario")
	@JsonBackReference("usuario-editoriales")
	private List<Editoriales> editoriales;

	// bi-directional many-to-one association to LibrosFavoritos
	@OneToMany(mappedBy = "usuario")
	@JsonBackReference("usuario-librosfavoritos")
	private List<LibrosFavoritos> librosfavoritos;

	// bi-directional many-to-one association to LibrosPublicados
	@OneToMany(mappedBy = "usuario")
	@JsonBackReference("usuario-librospublicados")
	private List<LibrosPublicados> librospublicados;

	// bi-directional many-to-one association to Membresias
	@OneToMany(mappedBy = "usuario")
	@JsonBackReference("usuario-membresias")
	private List<Membresias> membresias;

	// bi-directional many-to-one association to PublicacionesAutores
	@OneToMany(mappedBy = "usuario")
	@JsonBackReference("usuario-publicacionesautores")
	private List<PublicacionesAutores> publicacionesautores;

	// bi-directional many-to-one association to Transacciones
	@OneToMany(mappedBy = "usuario")
	@JsonBackReference("usuario-transacciones")
	private List<Transacciones> transacciones;

	// bi-directional many-to-one association to TarjetaCredito
	@OneToMany(mappedBy = "usuario")
	private List<TarjetaCredito> tarjetacredito;

	// bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "idRol")
	private Roles role;

	public Usuarios() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Calificaciones> getCalificaciones() {
		return this.calificaciones;
	}

	public void setCalificaciones(List<Calificaciones> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Calificaciones addCalificacione(Calificaciones calificacione) {
		getCalificaciones().add(calificacione);
		calificacione.setUsuario(this);

		return calificacione;
	}

	public Calificaciones removeCalificacione(Calificaciones calificacione) {
		getCalificaciones().remove(calificacione);
		calificacione.setUsuario(null);

		return calificacione;
	}

	public List<DatosUsuarios> getDatosusuarios() {
		return this.datosusuarios;
	}

	public void setDatosusuarios(List<DatosUsuarios> datosusuarios) {
		this.datosusuarios = datosusuarios;
	}

	public DatosUsuarios addDatosusuario(DatosUsuarios datosusuario) {
		getDatosusuarios().add(datosusuario);
		datosusuario.setUsuario(this);

		return datosusuario;
	}

	public DatosUsuarios removeDatosusuario(DatosUsuarios datosusuario) {
		getDatosusuarios().remove(datosusuario);
		datosusuario.setUsuario(null);

		return datosusuario;
	}

	public List<Editoriales> getEditoriales() {
		return this.editoriales;
	}

	public void setEditoriales(List<Editoriales> editoriales) {
		this.editoriales = editoriales;
	}

	public Editoriales addEditoriale(Editoriales editoriale) {
		getEditoriales().add(editoriale);
		editoriale.setUsuario(this);

		return editoriale;
	}

	public Editoriales removeEditoriale(Editoriales editoriale) {
		getEditoriales().remove(editoriale);
		editoriale.setUsuario(null);

		return editoriale;
	}

	public List<LibrosFavoritos> getLibrosfavoritos() {
		return this.librosfavoritos;
	}

	public void setLibrosfavoritos(List<LibrosFavoritos> librosfavoritos) {
		this.librosfavoritos = librosfavoritos;
	}

	public LibrosFavoritos addLibrosfavorito(LibrosFavoritos librosfavorito) {
		getLibrosfavoritos().add(librosfavorito);
		librosfavorito.setUsuario(this);

		return librosfavorito;
	}

	public LibrosFavoritos removeLibrosfavorito(LibrosFavoritos librosfavorito) {
		getLibrosfavoritos().remove(librosfavorito);
		librosfavorito.setUsuario(null);

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
		librospublicado.setUsuario(this);

		return librospublicado;
	}

	public LibrosPublicados removeLibrospublicado(LibrosPublicados librospublicado) {
		getLibrospublicados().remove(librospublicado);
		librospublicado.setUsuario(null);

		return librospublicado;
	}

	public List<Membresias> getMembresias() {
		return this.membresias;
	}

	public void setMembresias(List<Membresias> membresias) {
		this.membresias = membresias;
	}

	public Membresias addMembresia(Membresias membresia) {
		getMembresias().add(membresia);
		membresia.setUsuario(this);

		return membresia;
	}

	public Membresias removeMembresia(Membresias membresia) {
		getMembresias().remove(membresia);
		membresia.setUsuario(null);

		return membresia;
	}

	public List<PublicacionesAutores> getPublicacionesautores() {
		return this.publicacionesautores;
	}

	public void setPublicacionesautores(List<PublicacionesAutores> publicacionesautores) {
		this.publicacionesautores = publicacionesautores;
	}

	public PublicacionesAutores addPublicacionesautore(PublicacionesAutores publicacionesautore) {
		getPublicacionesautores().add(publicacionesautore);
		publicacionesautore.setUsuario(this);

		return publicacionesautore;
	}

	public PublicacionesAutores removePublicacionesautore(PublicacionesAutores publicacionesautore) {
		getPublicacionesautores().remove(publicacionesautore);
		publicacionesautore.setUsuario(null);

		return publicacionesautore;
	}

	public List<Transacciones> getTransacciones() {
		return this.transacciones;
	}

	public void setTransacciones(List<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

	public Transacciones addTransaccione(Transacciones transaccione) {
		getTransacciones().add(transaccione);
		transaccione.setUsuario(this);

		return transaccione;
	}

	public Transacciones removeTransaccione(Transacciones transaccione) {
		getTransacciones().remove(transaccione);
		transaccione.setUsuario(null);

		return transaccione;
	}

	public Roles getRole() {
		return this.role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public List<TarjetaCredito> getTarjetacredito() {
		return tarjetacredito;
	}

	public void setTarjetacredito(List<TarjetaCredito> tarjetacredito) {
		this.tarjetacredito = tarjetacredito;
	}

	public TarjetaCredito addTarjetacredito(TarjetaCredito tarjetacredito) {
		getTarjetacredito().add(tarjetacredito);
		tarjetacredito.setUsuario(this);

		return tarjetacredito;
	}

	public TarjetaCredito removeTarjetacredito(TarjetaCredito tarjetacredito) {
		getTarjetacredito().remove(tarjetacredito);
		tarjetacredito.setUsuario(null);

		return tarjetacredito;
	}

}