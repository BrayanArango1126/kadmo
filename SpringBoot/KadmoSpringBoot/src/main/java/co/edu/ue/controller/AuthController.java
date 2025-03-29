package co.edu.ue.controller;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.dto.LoginDTO;
import co.edu.ue.dto.UsuariosDTO;
import co.edu.ue.security.AuthorizationJWT;
import co.edu.ue.service.ILoginService;
import co.edu.ue.utils.ApiResponse;
import co.edu.ue.utils.Tools;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@CrossOrigin(origins = "*")
@RestController
public class AuthController {

	@Autowired
	private ILoginService service;

	AuthenticationManager authManager;

	@Autowired
	private AuthorizationJWT jwtTokenProvider;

	public AuthController(AuthenticationManager authManager) {
		super();
		this.authManager = authManager;

	}

	@PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<LoginDTO>> login(@RequestBody LoginDTO login) {
		try {
			// System.out.println("Controller Usuario autenticado: " + login.getCorreo() + "
			// " + login.getContraseña());
			LoginDTO logIn = this.service.login(login);
			if (logIn.getIdUsuario() == 0) {
				return new ResponseEntity<>(new ApiResponse<>("Usuario/contraseña inválidos", null), HttpStatus.UNAUTHORIZED);
			}
			String user = login.getCorreo();
			String pwd = login.getContraseña();

			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(user, pwd));
			// System.out.println("COntroller Usuario autenticado: " +
			// authentication.getName());
			// System.out.println("COntroller Autoridades: " +
			// authentication.getAuthorities());
			logIn.setToken(getToken(authentication));
			return new ResponseEntity<>(new ApiResponse<>("Usuario logueado correctamente", logIn), HttpStatus.OK);
		} catch (AuthenticationException ex) {
			ex.printStackTrace();
			System.out.println("Error de autenticación: " + ex.getMessage());
			return new ResponseEntity<>(new ApiResponse<>("Hubo un error en la salida", null), HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping(value = "login-face", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<LoginDTO>> loginFace(@RequestBody LoginDTO login) {
		try {
			// System.out.println("Controller Usuario autenticado: " + login.getCorreo() + "
			// " + login.getContraseña());

			String userMail = login.getCorreo();

			// buscar el usuario por correo
			LoginDTO logIn = this.service.loginFace(login);

			if (logIn.getIdUsuario() == 0) {
				return new ResponseEntity<>(new ApiResponse<>("Usuario inválidos", null), HttpStatus.UNAUTHORIZED);
			}

			// Generar un token para el usuario sin necesidad de autenticación con
			// contraseña
			String token = jwtTokenProvider.generateToken(userMail);

			logIn.setToken(token);
			return new ResponseEntity<>(new ApiResponse<>("Usuario logueado correctamente", logIn), HttpStatus.OK);
		} catch (AuthenticationException ex) {
			ex.printStackTrace();
			System.out.println("Error de autenticación: " + ex.getMessage());
			return new ResponseEntity<>(new ApiResponse<>("Hubo un error en la salida", null), HttpStatus.UNAUTHORIZED);
		}
	}

	private String getToken(Authentication authentication) {
		// Asegúrate de que estás obteniendo las autoridades correctas
		// List<String> authorities = authentication.getAuthorities().stream()
		// .map(GrantedAuthority::getAuthority)
		// .collect(Collectors.toList());

		// Imprimir las autoridades para depuración
		// System.out.println("*****************COntroller***********************");
		// System.out.println("Autoridades: " + authorities);
		// System.out.println("****************************************");
		String token = Jwts.builder()
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(authentication.getName())
				.claim("authorities", authentication.getAuthorities().stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
				.signWith(Keys.hmacShaKeyFor(Tools.CLAVE.getBytes()))
				.compact();
		return token;
	}
}
