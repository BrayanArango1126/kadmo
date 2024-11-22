package co.edu.ue.dto;

public class LibrosFavoritosDTO {

	private int idLibroFavorito;
	private LibrosDTO libro;
	private UsuariosDTO usuario;
	
	public int getIdLibroFavorito() {
		return idLibroFavorito;
	}
	public void setIdLibroFavorito(int idLibroFavorito) {
		this.idLibroFavorito = idLibroFavorito;
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
