package co.edu.ue.dto;

public class EditorialesDTO {

	private int idEditoriales;
	private String direccion;
	private String nombre;
	private String telefono;
	private UsuariosDTO usuario;
	
	public int getIdEditoriales() {
		return idEditoriales;
	}
	public void setIdEditoriales(int idEditorial) {
		this.idEditoriales = idEditorial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public UsuariosDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuariosDTO usuario) {
		this.usuario = usuario;
	}
	
	
}
