package co.edu.ue.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.ue.dto.UsuariosDTO;
import co.edu.ue.entity.Usuarios;

@Configuration
public class AppConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		// Configuración personalizada para Usuario -> UsuarioDTO
		modelMapper.typeMap(Usuarios.class, UsuariosDTO.class).addMappings(m -> {
	        m.map(src -> src.getRole(), UsuariosDTO::setRol); // Ejemplo de asignación manual
	    });
		
		
		return modelMapper;
	}
}
