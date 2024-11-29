package co.edu.ue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.ue.dto.LoginDTO;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.repository.dao.IUsuarioRepository;

@Service
public class LoginService implements ILoginService {

  @Autowired
  private IUsuarioRepository dao;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public LoginDTO login(LoginDTO login) {

    Usuarios user = this.dao.findByCorreo(login.getCorreo());

    if (user != null && passwordEncoder.matches(login.getContraseña(), user.getContraseña())) {
      return new LoginDTO(user.getIdUsuario(), user.getCorreo(), user.getRole().getIdRol());
    } else {
      return new LoginDTO();
    }
  }

}
