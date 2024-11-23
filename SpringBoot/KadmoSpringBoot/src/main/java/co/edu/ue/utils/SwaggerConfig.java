package co.edu.ue.utils;

import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
		info = @Info(
				title ="API KADMO",
				description = "Esta API permite el intercambio de información de la aplicación KADMO",
				termsOfService = "Para realizar cualquier operación dentro de la API se deben aceptar los terminos y condiciones",
				contact = @Contact(
						name="Brayan Arango", url="www.onyxwebstore.com"
						),
				version="1.0"
				),
		security = @SecurityRequirement(
				name="Security TokenJWT")
		)
@SecurityScheme(
		name="Security TokenJWT",
		description = "La seguridad de la Api es por medio de un Token JWT",
		type = SecuritySchemeType.HTTP,
		paramName = HttpHeaders.AUTHORIZATION,
		in = SecuritySchemeIn.HEADER,
		scheme="bearer",
		bearerFormat = "JWT"
		)
public class SwaggerConfig {

}
