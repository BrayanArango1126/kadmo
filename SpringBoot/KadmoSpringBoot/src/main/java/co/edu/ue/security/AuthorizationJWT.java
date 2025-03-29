package co.edu.ue.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

import org.springframework.stereotype.Service;

import co.edu.ue.utils.Tools;

@Service
public class AuthorizationJWT {

  public String generateToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Expira en 1 día
        .signWith(SignatureAlgorithm.HS256, Tools.CLAVESEGURA)
        .compact();
  }
}
