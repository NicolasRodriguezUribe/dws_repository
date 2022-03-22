package es.dws.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApplication.class, args);
	}
}
