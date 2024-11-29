package co.edu.ue.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	AuthenticationManager auth;

	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration conf) {
		try {
			auth = conf.getAuthenticationManager();
		} catch (Exception e) {
			System.out.println("" + e.getMessage());
			e.printStackTrace();
		}
		return auth;
	}

	@Bean
	public JdbcUserDetailsManager usersDetailsJdbc() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		// ds.setUrl("jdbc:mysql://localhost:3306/user_security_encr");
		ds.setUrl("jdbc:mysql://localhost:3306/kadmodb");
		ds.setUsername("root");
		ds.setPassword("");

		JdbcUserDetailsManager jdbcDetails = new JdbcUserDetailsManager(ds);

		/*
		 * jdbcDetails.setUsersByUsernameQuery("select use_user, use_pass, use_status"
		 * + " from users where use_user=? and use_status=1");
		 * 
		 * jdbcDetails.setAuthoritiesByUsernameQuery("SELECT use_user,rol FROM roles "
		 * + "WHERE use_user = ?");
		 */

		// Consulta para obtener usuario y contraseña
		jdbcDetails.setUsersByUsernameQuery(
				"SELECT correo AS username, contraseña AS password, 1 AS enabled " +
						"FROM usuarios WHERE correo = ?");

		// Consulta para obtener roles asociados al usuario
		jdbcDetails.setAuthoritiesByUsernameQuery(
				"SELECT u.correo AS username, r.rol AS authority " +
						"FROM usuarios u " +
						"JOIN roles r ON u.idRol = r.idRol " +
						"WHERE u.correo = ?");

		// printUsers(ds);
		return jdbcDetails;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		try {
			http.csrf(cus -> cus.disable())
					.authorizeHttpRequests(
							aut -> aut.requestMatchers(HttpMethod.POST, "/rol/add-rol").hasAnyRole("Administrador", "Cliente")
									.requestMatchers(HttpMethod.GET, "/rol/id-rol").hasAnyRole("Administrador")
									.requestMatchers(HttpMethod.GET, "/rol/roles").authenticated()
									.anyRequest().permitAll())
					.addFilter(new AuthorizationFilterJWT(auth));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return http.build();
	}

}
