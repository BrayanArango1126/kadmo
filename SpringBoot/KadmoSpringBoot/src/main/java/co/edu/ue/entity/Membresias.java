package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the membresias database table.
 * 
 */
@Entity
@Table(name="membresias")
@NamedQuery(name="Membresias.findAll", query="SELECT m FROM Membresias m")
public class Membresias implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idMembresia")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMembresia;

	@Column(name="estado")
	private byte estado;

	@Column(name="fechaFin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;

	@Column(name="fechaIncio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIncio;

	@Column(name="tipo")
	private String tipo;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuarios usuario;

	public Membresias() {
	}

	public int getIdMembresia() {
		return this.idMembresia;
	}

	public void setIdMembresia(int idMembresia) {
		this.idMembresia = idMembresia;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaIncio() {
		return this.fechaIncio;
	}

	public void setFechaIncio(Date fechaIncio) {
		this.fechaIncio = fechaIncio;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}