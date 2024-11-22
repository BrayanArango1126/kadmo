package co.edu.ue.dto;

public class TransaccionesDTO {

	private int idTransaccion;
	private LibrosDTO libro;
	private UsuariosDTO usuario;
	private Double total;
	private EstadosTransaccionesDTO estadosTransaccione;
	
	public int getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public LibrosDTO getLibro() {
		return libro;
	}
	public void setLibro(LibrosDTO libro) {
		this.libro = libro;
	}
	public UsuariosDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuariosDTO usuario) {
		this.usuario = usuario;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public EstadosTransaccionesDTO getEstadosTransaccione() {
		return estadosTransaccione;
	}
	public void setEstadosTransaccione(EstadosTransaccionesDTO estadosTransaccione) {
		this.estadosTransaccione = estadosTransaccione;
	}
	
	
}
