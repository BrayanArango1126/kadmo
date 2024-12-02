package co.edu.ue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.dto.LoginDTO;
import co.edu.ue.service.ILoginService;
import co.edu.ue.utils.ApiResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "login")
public class LoginController {

  @Autowired
  private ILoginService service;

  @PostMapping("in")
  public ResponseEntity<ApiResponse<LoginDTO>> iniciarSesion(@RequestBody LoginDTO inicioSesion) {
    LoginDTO login = this.service.login(inicioSesion);
    return new ResponseEntity<>(new ApiResponse<>("Inicio de Sesión Correcto", login), HttpStatus.OK);
  }

}
