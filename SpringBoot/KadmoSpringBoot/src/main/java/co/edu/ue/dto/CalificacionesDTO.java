package co.edu.ue.dto;

import java.sql.Date;

public class CalificacionesDTO {

	private int idCalificacion;
	private LibrosDTO libro;
	private UsuariosDTO usuario;
	private String comentario;
	private Date fechaCalificacion;
	private String puntuacion;

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

	public Date getFechaCalificacion() {
		return fechaCalificacion;
	}

	public void setFechaCalificacion(Date fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}

	public String getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

}
