package co.edu.ue.dto;

public class EstadosTransaccionesDTO {

	private int idEstadoTransaccion;
    private String estado;

    // Getters y Setters
    public int getIdEstadoTransaccion() {
        return idEstadoTransaccion;
    }

    public void setIdEstadoTransaccion(int idEstadoTransaccion) {
        this.idEstadoTransaccion = idEstadoTransaccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
	@Override
	public String toString() {
		return "EstadosTransaccionesDTO [idEstadoTransaccion=" + idEstadoTransaccion + ", estado=" + estado + "]";
	}
	
	
	
	
}
