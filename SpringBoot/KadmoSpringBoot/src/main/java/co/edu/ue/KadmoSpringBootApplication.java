package co.edu.ue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"co.edu.ue.entity"})
@EnableJpaRepositories(basePackages = {"co.edu.ue.repository.jpa"})
@ComponentScan(basePackages = {"co.edu.ue.repository.dao", "co.edu.ue.controller", "co.edu.ue.service", "co.edu.ue.config", "co.edu.ue.dto", "co.edu.ue.security"})
public class KadmoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(KadmoSpringBootApplication.class, args);
	}

}
