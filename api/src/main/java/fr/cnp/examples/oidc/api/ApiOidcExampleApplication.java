package fr.cnp.examples.oidc.api;

import fr.cnp.examples.oidc.api.config.RequestContextUser;
import fr.cnp.examples.oidc.api.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class ApiOidcExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiOidcExampleApplication.class, args);
	}
}
