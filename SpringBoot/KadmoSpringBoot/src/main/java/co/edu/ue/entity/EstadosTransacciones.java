package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the estadostransacciones database table.
 * 
 */
@Entity
@Table(name="estadostransacciones")
@NamedQuery(name="EstadosTransacciones.findAll", query="SELECT e FROM EstadosTransacciones e")
public class EstadosTransacciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idEstadoTransaccion")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstadoTransaccion;

	@NotNull(message = "El campo de estado de transaccion no se envió")
	@NotBlank(message = "El campo de estado de transaccion no puede estar vacio")
	@Column(name="estado")
	private String estado;

	//bi-directional many-to-one association to Transacciones
	@OneToMany(mappedBy="estadostransaccione")
	private List<Transacciones> transacciones;

	public EstadosTransacciones() {
	}

	public int getIdEstadoTransaccion() {
		return this.idEstadoTransaccion;
	}

	public void setIdEstadoTransaccion(int idEstadoTransaccion) {
		this.idEstadoTransaccion = idEstadoTransaccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Transacciones> getTransacciones() {
		return this.transacciones;
	}

	public void setTransacciones(List<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

	public Transacciones addTransaccione(Transacciones transaccione) {
		getTransacciones().add(transaccione);
		transaccione.setEstadostransaccione(this);

		return transaccione;
	}

	public Transacciones removeTransaccione(Transacciones transaccione) {
		getTransacciones().remove(transaccione);
		transaccione.setEstadostransaccione(null);

		return transaccione;
	}

}