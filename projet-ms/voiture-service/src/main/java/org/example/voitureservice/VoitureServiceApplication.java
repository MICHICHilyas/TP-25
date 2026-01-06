package org.example.voitureservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale du microservice de gestion des voitures.
 * Cette application Spring Boot gère les opérations CRUD sur les voitures.
 * @author Ilyas MICHICH
 * @version 1.0
 */
@SpringBootApplication
public class VoitureServiceApplication {

	/**
	 * Point d'entrée principal de l'application.
	 * Lance le contexte Spring Boot pour le service voiture.
	 * @param args Arguments de la ligne de commande
	 */
	public static void main(String[] args) {
		SpringApplication.run(VoitureServiceApplication.class, args);
	}

}
