package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Roles.findAll", query="SELECT r FROM Roles r")
public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idRol")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRol;
	
	@Column(name="fechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

	@NotNull(message = "El campo de rol no se envió")
	@NotBlank(message = "El campo de rol no puede estar vacio")
	@Column(name="rol")
	private String rol;

	//bi-directional many-to-one association to Usuarios
	@OneToMany(mappedBy="role")
	@JsonBackReference("role-usuarios")
	private List<Usuarios> usuarios;

	public Roles() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Usuarios> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuarios addUsuario(Usuarios usuario) {
		getUsuarios().add(usuario);
		usuario.setRole(this);

		return usuario;
	}

	public Usuarios removeUsuario(Usuarios usuario) {
		getUsuarios().remove(usuario);
		usuario.setRole(null);

		return usuario;
	}

}