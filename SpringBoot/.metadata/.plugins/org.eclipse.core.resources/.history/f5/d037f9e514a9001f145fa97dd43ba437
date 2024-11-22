package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


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

	@Column(name="direccion")
	private String direccion;

	@Column(name="nombre")
	private String nombre;

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