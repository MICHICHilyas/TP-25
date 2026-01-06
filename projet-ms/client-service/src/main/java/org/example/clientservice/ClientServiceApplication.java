package org.example.clientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale du microservice de gestion des clients.
 * Cette application Spring Boot gère les opérations CRUD sur les clients.
 * @author Ilyas MICHICH
 * @version 1.0
 */
@SpringBootApplication
public class ClientServiceApplication {

	/**
	 * Point d'entrée principal de l'application.
	 * Lance le contexte Spring Boot pour le service client.
	 * @param args Arguments de la ligne de commande
	 */
	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

}
