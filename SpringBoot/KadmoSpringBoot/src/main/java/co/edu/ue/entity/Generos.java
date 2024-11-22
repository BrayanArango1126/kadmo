package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the generos database table.
 * 
 */
@Entity
@Table(name="generos")
@NamedQuery(name="Generos.findAll", query="SELECT g FROM Generos g")
public class Generos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idGenero")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGenero;

	@Column(name="fechaPublicacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPublicacion;

	@NotNull(message = "El campo de genero no se envió")
	@NotBlank(message = "El campo de genero no puede estar vacio")
	@Column(name="genero")
	private String genero;

	//bi-directional many-to-one association to DatosUsuarios
	@OneToMany(mappedBy="genero")
	@JsonBackReference
	private List<DatosUsuarios> datosusuarios;

	public Generos() {
	}

	public int getIdGenero() {
		return this.idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<DatosUsuarios> getDatosusuarios() {
		return this.datosusuarios;
	}

	public void setDatosusuarios(List<DatosUsuarios> datosusuarios) {
		this.datosusuarios = datosusuarios;
	}

	public DatosUsuarios addDatosusuario(DatosUsuarios datosusuario) {
		getDatosusuarios().add(datosusuario);
		datosusuario.setGenero(this);

		return datosusuario;
	}

	public DatosUsuarios removeDatosusuario(DatosUsuarios datosusuario) {
		getDatosusuarios().remove(datosusuario);
		datosusuario.setGenero(null);

		return datosusuario;
	}

}