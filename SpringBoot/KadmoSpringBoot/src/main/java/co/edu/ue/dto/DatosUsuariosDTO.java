package co.edu.ue.dto;


public class DatosUsuariosDTO {
	private int idDatoUsuario;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String documento;
	private int edad;
	private int usuarioVerificado;
	GenerosDTO genero;
	UsuariosDTO usuario;
	
	public int getIdDatoUsuario() {
		return idDatoUsuario;
	}
	public void setIdDatoUsuario(int idDatoUsuario) {
		this.idDatoUsuario = idDatoUsuario;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getUsuarioVerificado() {
		return usuarioVerificado;
	}
	public void setUsuarioVerificado(int usuarioVerificado) {
		this.usuarioVerificado = usuarioVerificado;
	}
	public GenerosDTO getGenero() {
		return genero;
	}
	public void setGenero(GenerosDTO genero) {
		this.genero = genero;
	}
	public UsuariosDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuariosDTO usuario) {
		this.usuario = usuario;
	}
	
	
}
