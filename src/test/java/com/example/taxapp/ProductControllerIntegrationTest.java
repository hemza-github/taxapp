package com.example.taxapp;

import com.example.taxapp.model.Country;
import com.example.taxapp.model.Product;
import com.example.taxapp.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTest {

    @LocalServerPort
    private int port;  // Le port où l'application est lancée pendant les tests

    @Autowired
    private TestRestTemplate restTemplate;  // Client HTTP pour tester les API

    @Autowired
    private ProductRepository productRepository;  // Pour manipuler la base de données dans le test

    @BeforeEach
    public void setUp() {
        // Réinitialiser la base de données avant chaque test
        productRepository.deleteAll();  // Supprimer tous les produits de la base de données
    }

    // Test pour créer un produit
    @Test
    public void testCreateProduct() throws Exception {
        // Création d'un produit de test
        Product product = new Product("Test Product", new BigDecimal("100.00"), Country.USA);

        // Envoi de la requête POST pour créer un produit
        ResponseEntity<Product> response = restTemplate.postForEntity("http://localhost:" + port + "/products", product, Product.class);

        // Vérification de la réponse
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Test Product");
        assertThat(response.getBody().getPrice()).isEqualTo(new BigDecimal("100.00"));
    }

    // Test pour récupérer un produit par son ID
    @Test
    public void testGetProductById() throws Exception {
        // Créer un produit dans la base de données
        Product product = new Product("Test Product", new BigDecimal("100.00"), Country.USA);
        product = productRepository.save(product);  // Sauvegarder le produit dans la base

        // Envoi de la requête GET pour récupérer le produit par son ID
        ResponseEntity<Product> response = restTemplate.getForEntity("http://localhost:" + port + "/products/" + product.getId(), Product.class);

        // Vérification de la réponse
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Test Product");
        assertThat(response.getBody().getPrice()).isEqualTo(new BigDecimal("100.00"));
    }

    // Test pour calculer la taxe sur un produit
    @Test
    public void testCalculateTax() throws Exception {
        // Créer un produit
        Product product = new Product("Test Product", new BigDecimal("100.00"), Country.USA);
        product = productRepository.save(product);  // Sauvegarder le produit dans la base

        // Envoi de la requête GET pour calculer la taxe
        ResponseEntity<BigDecimal> response = restTemplate.getForEntity("http://localhost:" + port + "/products/" + product.getId() + "/tax", BigDecimal.class);

        // Vérification de la réponse
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        // Vérifiez que la taxe est correctement calculée (par exemple, 10% de 100.00)
        assertThat(response.getBody()).isEqualTo(new BigDecimal("10.00"));
    }
}
