package co.edu.co.utils;

public class ApiResponse<T> {

	private String message;
	private T Datos;
	
	public ApiResponse(String message, T datos) {
		super();
		this.message = message;
		Datos = datos;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getDatos() {
		return Datos;
	}
	public void setDatos(T datos) {
		Datos = datos;
	}
	
	
}
