package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


/**
 * The persistent class for the editoriales database table.
 * 
 */
@Entity
@Table(name="editoriales")
@NamedQuery(name="Editoriales.findAll", query="SELECT e FROM Editoriales e")
public class Editoriales implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idEditoriales")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEditoriales;

	@NotNull(message = "El campo de categoría no se envió")
	@NotBlank(message = "El campo de categoría no puede estar vacio")
	@Column(name="direccion")
	private String direccion;

	@NotNull(message = "El campo de categoría no se envió")
	@NotBlank(message = "El campo de categoría no puede estar vacio")
	@Column(name="nombre")
	private String nombre;

	@NotNull(message = "El campo de categoría no se envió")
	@NotBlank(message = "El campo de categoría no puede estar vacio")
	@Pattern(regexp="^3(00|04|10|11|12|13|14|15|16|17|18|20|21|22|23|30)\\d{7}$", message="Hay un error en el número telefónico, verifícalo")
	@Column(name="telefono")
	private String telefono;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuarios usuario;

	public Editoriales() {
	}

	public int getIdEditoriales() {
		return this.idEditoriales;
	}

	public void setIdEditoriales(int idEditoriales) {
		this.idEditoriales = idEditoriales;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}