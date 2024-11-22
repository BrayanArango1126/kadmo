package co.edu.ue.entity;

import java.io.Serializable;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


/**
 * The persistent class for the datosusuarios database table.
 * 
 */
@Entity
@Table(name="datosusuarios")
@NamedQuery(name="DatosUsuarios.findAll", query="SELECT d FROM DatosUsuarios d")
public class DatosUsuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idDatoUsuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDatoUsuario;

	@NotNull(message = "El campo de apellidos no se envió")
	@NotBlank(message = "El campo de apellidos no puede estar vacio")
	@Pattern(regexp="^([A-Z][a-z]{0,14}(\\s[A-Z][a-z]{0,14})?)$", message="Hay un error en los apellidos, la inicial de cada apellido debe ser en mayúscula")
	@Column(name="apellidos")
	private String apellidos;

	@NotNull(message = "El campo de dirección no se envió")
	@NotBlank(message = "El campo de dirección no puede estar vacio")
	@Column(name="direccion")
	private String direccion;

	@NotNull(message = "El campo de documento no se envió")
	@NotBlank(message = "El campo de documento no puede estar vacio")
	@Pattern(regexp= "^1\\d{9}$", message = "El número de documento no es válido")
	@Column(name="documento")
	private String documento;

	
	@Column(name="edad")
	private int edad;

	@NotNull(message = "El campo de nombres no se envió")
	@NotBlank(message = "El campo de nombres no puede estar vacio")
	@Pattern(regexp="^([A-Z][a-z]{0,14}(\\s[A-Z][a-z]{0,14})?)$", message="Hay un error en los nombres, la inicial de cada nombre debe ser en mayúscula")
	@Column(name="nombres")
	private String nombres;

	@NotNull(message = "El campo de teléfono no se envió")
	@NotBlank(message = "El campo de teléfono no puede estar vacio")
	@Pattern(regexp="^3(00|04|10|11|12|13|14|15|16|17|18|20|21|22|23|30)\\d{7}$", message="Hay un error en el número telefónico, verifícalo")
	@Column(name="telefono")
	private String telefono;

	@Column(name="usuarioVerificado")
	private byte usuarioVerificado;

	//bi-directional many-to-one association to Generos
	@ManyToOne
	@JoinColumn(name="idGenero")
	private Generos genero;

	//bi-directional many-to-one association to Usuarios
	
	//@ManyToOne
	@OneToOne
	@JoinColumn(name="idUsuario")
	private Usuarios usuario;

	public DatosUsuarios() {
	}

	public int getIdDatoUsuario() {
		return this.idDatoUsuario;
	}

	public void setIdDatoUsuario(int idDatoUsuario) {
		this.idDatoUsuario = idDatoUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public byte getUsuarioVerificado() {
		return this.usuarioVerificado;
	}

	public void setUsuarioVerificado(byte usuarioVerificado) {
		this.usuarioVerificado = usuarioVerificado;
	}

	public Generos getGenero() {
		return this.genero;
	}

	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}