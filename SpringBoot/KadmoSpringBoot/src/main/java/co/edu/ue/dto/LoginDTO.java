package co.edu.ue.dto;

public class LoginDTO {
  private int idUsuario;
  private String correo;
  private String contraseña;
  private String token;
  private int rol;

  public LoginDTO() {
  }

  public LoginDTO(int idUsuario, String correo, int rol) {
    this.idUsuario = idUsuario;
    this.correo = correo;
    this.rol = rol;
  }

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

  public int getRol() {
    return rol;
  }

  public void setRol(int rol) {
    this.rol = rol;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return "LoginDTO [correo=" + correo + ", idUsuario=" + idUsuario + ", rol=" + rol + "]";
  }

}
