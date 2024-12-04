package co.edu.ue.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.model.Model;
import co.edu.ue.dto.TarjetaCreditoDTO;
import co.edu.ue.dto.UsuariosDTO;
import co.edu.ue.entity.TarjetaCredito;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.service.ITarjetaCreditoService;
import co.edu.ue.utils.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "tarjeta-credito")
public class TarjetaCreditoController {

  @Autowired
  ModelMapper modelMapper;

  @Autowired
  ITarjetaCreditoService service;

  @GetMapping(value = "tarjetas-credito", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TarjetaCreditoDTO>> getAllTarjetasCredito() {
    return new ResponseEntity<List<TarjetaCreditoDTO>>(this.service.listAllTarjetaCredito(), HttpStatus.ACCEPTED);
  }

  @GetMapping(value = "tarjeta-credito-id", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TarjetaCreditoDTO> getTarjetaCreditoById(@RequestParam("idTarjetaCredito") int id) {
    return new ResponseEntity<TarjetaCreditoDTO>(this.service.findIdTarjetaCredito(id), HttpStatus.ACCEPTED);
  }

  @PostMapping(value = "tarjeta-credito-id-usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<TarjetaCreditoDTO>> getTarjetasCreditoByUser(@RequestBody UsuariosDTO user) {
    Usuarios entity = this.modelMapper.map(user, Usuarios.class);
    List<TarjetaCreditoDTO> tarjetas = this.service.findByUsuario(entity);

    return new ResponseEntity<List<TarjetaCreditoDTO>>(tarjetas, HttpStatus.ACCEPTED);
  }

  @PostMapping(value = "add-tarjeta-credito", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ApiResponse<TarjetaCreditoDTO>> postTarjetaCredito(@RequestBody TarjetaCreditoDTO tarjeta) {
    TarjetaCredito entity = this.modelMapper.map(tarjeta, TarjetaCredito.class);
    TarjetaCreditoDTO tarjetaDTO = this.service.addTarjetaCredito(entity);

    return new ResponseEntity<>(new ApiResponse<>("Tarjeta de Crédito agregada correctamente", tarjetaDTO),
        HttpStatus.CREATED);
  }

  @PutMapping(value = "update-tarjeta-credito", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ApiResponse<TarjetaCreditoDTO>> putTarjetaCredito(@RequestBody TarjetaCreditoDTO tarjeta) {
    TarjetaCredito entity = this.modelMapper.map(tarjeta, TarjetaCredito.class);
    TarjetaCreditoDTO tarjetaDTO = this.service.updTarjetaCredito(entity);
    return new ResponseEntity<>(new ApiResponse<>("Tarjeta de Crédito actualizada correctamente", tarjetaDTO),
        HttpStatus.OK);
  }

}
