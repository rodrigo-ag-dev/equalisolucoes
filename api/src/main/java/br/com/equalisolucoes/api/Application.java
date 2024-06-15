package br.com.equalisolucoes.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
	info = @Info(
					title = "Equalisoluções - API",
					version = "0.1",
					description = "About me",
					license = @License( name = "Equalisoluções", 
														  url = "https://www.instagram.com/equalisolucoes/"
														),
					contact = @Contact( name = "Rodrigo Alexandre Gonçalves", 
															email = "rodrigo.ag.dev@gmail.com",
															url = "https://www.linkedin.com/in/rodrigo-alexandre-goncalves/"
													  )
	),
	externalDocs = @ExternalDocumentation(description = "definition docs desc")	
)

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}