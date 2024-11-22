package co.edu.ue.dto;

public class LibrosPublicadosDTO {

	private int idLibrosPublicados;
	private LibrosDTO libro;
	private UsuariosDTO usuario;
	
	public int getIdLibrosPublicados() {
		return idLibrosPublicados;
	}
	public void setIdLibrosPublicados(int idLibrosPublicados) {
		this.idLibrosPublicados = idLibrosPublicados;
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
	
	
}
