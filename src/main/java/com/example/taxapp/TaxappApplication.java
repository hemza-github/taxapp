package com.example.taxapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Annotation qui combine plusieurs annotations de Spring Boot :
// 1. `@Configuration` : Indique que cette classe peut contenir des configurations de l'application.
// 2. `@EnableAutoConfiguration` : Permet à Spring Boot de configurer automatiquement les beans en fonction des dépendances.
// 3. `@ComponentScan` : Indique à Spring de scanner ce package et ses sous-packages pour trouver des composants (comme les contrôleurs, services, etc.).

public class TaxappApplication {

	// Déclaration de la classe principale de l'application. 
	// En Spring Boot, la classe principale est celle qui contient la méthode `main`.

	public static void main(String[] args) {
		    // Méthode principale qui sert de point d'entrée pour démarrer l'application Java.

		SpringApplication.run(TaxappApplication.class, args);

		 // `SpringApplication.run` démarre l'application Spring Boot.
         // Elle initialise le contexte d'application, configure les beans et démarre un serveur intégré (comme Tomcat) si nécessaire.
   
	}

}
