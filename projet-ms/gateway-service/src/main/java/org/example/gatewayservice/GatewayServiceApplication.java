package org.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale du microservice Gateway (Passerelle).
 * Cette application Spring Boot sert de point d'entrée unique pour tous les microservices.
 * @author Ilyas MICHICH
 * @version 1.0
 */
@SpringBootApplication
public class GatewayServiceApplication {

	/**
	 * Point d'entrée principal de l'application.
	 * Lance le contexte Spring Boot pour le service gateway.
	 * @param args Arguments de la ligne de commande
	 */
	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

}
