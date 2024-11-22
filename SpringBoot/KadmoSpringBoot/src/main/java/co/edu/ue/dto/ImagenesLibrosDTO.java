package co.edu.ue.dto;

public class ImagenesLibrosDTO {

	private int idImagenLibro;
	private String url;
	private LibrosDTO libro;
	
	public int getIdImagenLibro() {
		return idImagenLibro;
	}
	public void setIdImagenLibro(int idImagenLibro) {
		this.idImagenLibro = idImagenLibro;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LibrosDTO getLibro() {
		return libro;
	}
	public void setLibro(LibrosDTO libro) {
		this.libro = libro;
	}
	
	
}
