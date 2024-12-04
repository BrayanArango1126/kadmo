package co.edu.ue.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * The persistent class for the tarjetacredito database table.
 * 
 */
@Entity
@Table(name = "tarjetacredito")
@NamedQuery(name = "TarjetaCredito.findAll", query = "SELECT t FROM TarjetaCredito t")
public class TarjetaCredito implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idTarjetaCredito")
  private int idTarjetaCredito;

  @NotNull(message = "El campo de titular no se envió")
  @NotBlank(message = "El campo de titular no puede estar vacio")
  @Column(name = "titular")
  private String titular;

  @NotNull(message = "El campo de número de tarjeta no se envió")
  @NotBlank(message = "El campo de número no tarjeta puede estar vacio")
  @Column(name = "numeroTarjeta")
  private String numeroTarjeta;

  @NotNull(message = "El campo de fecha de expiración no se envió")
  @NotBlank(message = "El campo de fecha de expiración no puede estar vacio")
  @Column(name = "fechaExpiracion")
  private String fechaExpiracion;

  @NotNull(message = "El campo de código de seguridad no se envió")
  @NotBlank(message = "El campo de código de seguridad no puede estar vacio")
  @Column(name = "cvs")
  private String cvs;

  // bi-directional many-to-one association to Transaccion
  @OneToMany(mappedBy = "tarjetacredito")
  private List<Transacciones> transacciones;

  // bi-directional many-to-one association to Membresia
  @OneToMany(mappedBy = "tarjetacredito")
  private List<Membresias> membresia;

  // bi-directional many-to-one association to Usuarios
  @ManyToOne
  @JoinColumn(name = "idUsuario")
  private Usuarios usuario;

  public TarjetaCredito() {
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

  public List<Transacciones> getTransacciones() {
    return transacciones;
  }

  public void setTransacciones(List<Transacciones> transacciones) {
    this.transacciones = transacciones;
  }

  public Usuarios getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuarios usuario) {
    this.usuario = usuario;
  }

  public Transacciones addTransacciones(Transacciones transacciones) {
    getTransacciones().add(transacciones);
    transacciones.setTarjetacredito(this);

    return transacciones;
  }

  public Transacciones removeTransacciones(Transacciones transacciones) {
    getTransacciones().remove(transacciones);
    transacciones.setTarjetacredito(null);

    return transacciones;
  }

  public List<Membresias> getMembresia() {
    return membresia;
  }

  public void setMembresia(List<Membresias> membresia) {
    this.membresia = membresia;
  }

  public Membresias addMembresia(Membresias membresia) {
    getMembresia().add(membresia);
    membresia.setTarjetacredito(this);

    return membresia;
  }

  public Membresias removeMembresia(Membresias membresia) {
    getMembresia().remove(membresia);
    membresia.setTarjetacredito(null);

    return membresia;
  }

}
