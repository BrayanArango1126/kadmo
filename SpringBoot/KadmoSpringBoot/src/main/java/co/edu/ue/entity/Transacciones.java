package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * The persistent class for the transacciones database table.
 * 
 */
@Entity
@Table(name = "transacciones")
@NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t")
public class Transacciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idTransaccion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransaccion;

	@Column(name = "fechaTransaccion")
	private LocalDate fechaTransaccion;
	// @Column(name = "fechaTransaccion")
	// @Temporal(TemporalType.TIMESTAMP)
	// private Date fechaTransaccion;

	@Column(name = "total")
	private BigDecimal total;

	// bi-directional many-to-one association to EstadosTransacciones
	@ManyToOne
	@JoinColumn(name = "idEstadoTransaccion")
	private EstadosTransacciones estadostransaccione;

	// bi-directional many-to-one association to Libros
	@ManyToOne
	@JoinColumn(name = "idLibro")
	private Libros libro;

	// bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuarios usuario;

	// bi-directional many-to-one association to TarjetaCredito
	@ManyToOne
	@JoinColumn(name = "idTarjetaCredito")
	private TarjetaCredito tarjetacredito;

	public Transacciones() {
	}

	public int getIdTransaccion() {
		return this.idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public LocalDate getFechaTransaccion() {
		return this.fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public EstadosTransacciones getEstadostransaccione() {
		return this.estadostransaccione;
	}

	public void setEstadostransaccione(EstadosTransacciones estadostransaccione) {
		this.estadostransaccione = estadostransaccione;
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

	public TarjetaCredito getTarjetacredito() {
		return tarjetacredito;
	}

	public void setTarjetacredito(TarjetaCredito tarjetacredito) {
		this.tarjetacredito = tarjetacredito;
	}

}