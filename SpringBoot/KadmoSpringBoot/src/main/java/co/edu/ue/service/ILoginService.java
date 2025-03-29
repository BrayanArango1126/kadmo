package co.edu.ue.service;

import co.edu.ue.dto.LoginDTO;

public interface ILoginService {
  LoginDTO login(LoginDTO login);

  LoginDTO loginFace(LoginDTO loginFace);
}
