package co.edu.ue.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CalificacionesLibroDTO {
    private int idCalificacion;
    private int idLibro;
    private String nombreLibro;
	private String comentario;
	private double puntuacion;
	private String fechaCalificacion;
    private String autorLibro;
    private double precioLibro;
    private String descripcionLibro;
    private int idUsuario;
    private String nombresUsuario;
    private String apellidosUsuario;
	Timestamp timestamp;

    // Constructor
    public CalificacionesLibroDTO(int idCalificacion, int idLibro, String nombreLibro, String comentario, String autorLibro,
                                   double precioLibro, String descripcionLibro, int idUsuario,
                                   String nombresUsuario, String apellidosUsuario) {
        this.idCalificacion = idCalificacion;
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.autorLibro = autorLibro;
        this.comentario = comentario;
        this.precioLibro = precioLibro;
        this.descripcionLibro = descripcionLibro;
        this.idUsuario = idUsuario;
        this.nombresUsuario = nombresUsuario;
        this.apellidosUsuario = apellidosUsuario;
    }
	public CalificacionesLibroDTO(Object[] resultado) {
        this.idCalificacion = ((Number) resultado[0]).intValue();
        this.idLibro = ((Number) resultado[1]).intValue();
        this.nombreLibro = (String) resultado[2];
        this.comentario = (String) resultado[3];
        this.puntuacion = ((Number) resultado[4]).doubleValue();
		 // Conversión de Timestamp
		this.timestamp = (Timestamp) resultado[5];
        this.fechaCalificacion = new SimpleDateFormat("yyyy-MM-dd").format(timestamp);
        this.autorLibro = (String) resultado[6];
        this.precioLibro = ((Number) resultado[7]).doubleValue();
        this.descripcionLibro = (String) resultado[8];
        this.idUsuario = ((Number) resultado[9]).intValue();
        this.nombresUsuario = (String) resultado[10];
        this.apellidosUsuario = (String) resultado[11];
    }	

    // Getters y Setters

	public int getIdCalificacion() {
		return idCalificacion;
	}

	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getFechaCalificacion() {
		return fechaCalificacion;
	}

	public void setFechaCalificacion(String fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}

	public String getAutorLibro() {
		return autorLibro;
	}

	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}

	public double getPrecioLibro() {
		return precioLibro;
	}

	public void setPrecioLibro(double precioLibro) {
		this.precioLibro = precioLibro;
	}

	public String getDescripcionLibro() {
		return descripcionLibro;
	}

	public void setDescripcionLibro(String descripcionLibro) {
		this.descripcionLibro = descripcionLibro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombresUsuario() {
		return nombresUsuario;
	}

	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}

	public String getApellidosUsuario() {
		return apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	
}
