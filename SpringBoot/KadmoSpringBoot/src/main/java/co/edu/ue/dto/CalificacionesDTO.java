package co.edu.ue.dto;

public class CalificacionesDTO {

	private int idCalificacion;
	private LibrosDTO libro;
	private UsuariosDTO usuario;
	private String comentario;
	private Double puntuacion;
	
	
	public int getIdCalificacion() {
		return idCalificacion;
	}
	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
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
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Double getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	
}
