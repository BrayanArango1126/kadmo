package co.edu.ue.dto;


public class UsuariosDTO {

	private int idUsuario;
	private String correo;
	private String contraseña;
	private RolDTO rol;
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public RolDTO getRol() {
		return rol;
	}
	public void setRol(RolDTO rol) {
		this.rol = rol;
	}
	
	
}
