package co.edu.ue.dto;

public class TarjetaCreditoDTO {
  private int idTarjetaCredito;
  private UsuariosDTO usuario;
  private String titular;
  private String numeroTarjeta;
  private String fechaExpiracion;
  private String cvs;

  public TarjetaCreditoDTO() {
  }

  public int getIdTarjetaCredito() {
    return idTarjetaCredito;
  }

  public void setIdTarjetaCredito(int idTarjetaCredito) {
    this.idTarjetaCredito = idTarjetaCredito;
  }

  public String getTitular() {
    return titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public String getNumeroTarjeta() {
    return numeroTarjeta;
  }

  public void setNumeroTarjeta(String numeroTarjeta) {
    this.numeroTarjeta = numeroTarjeta;
  }

  public String getFechaExpiracion() {
    return fechaExpiracion;
  }

  public void setFechaExpiracion(String fechaExpiracion) {
    this.fechaExpiracion = fechaExpiracion;
  }

  public String getCvs() {
    return cvs;
  }

  public void setCvs(String cvs) {
    this.cvs = cvs;
  }

  public UsuariosDTO getUsuario() {
    return usuario;
  }

  public void setUsuario(UsuariosDTO usuario) {
    this.usuario = usuario;
  }

}
