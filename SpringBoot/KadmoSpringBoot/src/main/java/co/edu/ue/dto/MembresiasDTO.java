package co.edu.ue.dto;

import java.sql.Date;

public class MembresiasDTO {

	private int idMembresia;
	private String tipo;
	private int estado;
	private double pago;
	private Date fechaIncio;
	private Date fechaFin;
	private UsuariosDTO usuario;
	private TarjetaCreditoDTO tarjetaCredito;

	public int getIdMembresia() {
		return idMembresia;
	}

	public void setIdMembresia(int idMembresia) {
		this.idMembresia = idMembresia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaIncio() {
		return fechaIncio;
	}

	public void setFechaIncio(Date fechaInicio) {
		this.fechaIncio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public UsuariosDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuariosDTO usuario) {
		this.usuario = usuario;
	}

	public double getPago() {
		return pago;
	}

	public void setPago(double pago) {
		this.pago = pago;
	}

	public TarjetaCreditoDTO getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(TarjetaCreditoDTO tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

}
