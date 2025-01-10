package com.example.taxapp.controller;

// Importation des classes nécessaires pour les entités et services
import com.example.taxapp.model.Product;
import com.example.taxapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

// Annotation qui définit cette classe comme un contrôleur REST, ce qui permet de gérer les requêtes HTTP entrantes
@RestController

// Définition de l'URL de base pour toutes les routes de ce contrôleur
@RequestMapping("/products")
public class ProductController {

    // Injection automatique du service ProductService pour gérer la logique métier
    @Autowired
    private ProductService productService;

    // Endpoint pour créer un produit (HTTP POST)
    // L'annotation @PostMapping indique que cette méthode répond aux requêtes POST à l'URL /products
    // La méthode prend un objet Product en entrée, qui est désérialisé à partir du corps de la requête HTTP (via @RequestBody)
    // Retourne l'objet Product créé, comme réponse à la requête
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // Endpoint pour récupérer un produit par son ID (HTTP GET)
    // L'annotation @GetMapping définit que cette méthode répond aux requêtes GET à l'URL /products/{id}
    // Le paramètre {id} est capturé à partir de l'URL et injecté dans la méthode avec l'annotation @PathVariable
    // Retourne un objet Product récupéré par l'ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

      // Endpoint pour calculer la taxe d'un produit par son ID (HTTP GET)
    // L'annotation @GetMapping définit que cette méthode répond aux requêtes GET à l'URL /products/{id}/tax
    // Le paramètre {id} est capturé à partir de l'URL et injecté dans la méthode avec l'annotation @PathVariable
    // Retourne un BigDecimal représentant le montant de la taxe calculée pour le produit
    @GetMapping("/{id}/tax")
    public BigDecimal calculateTax(@PathVariable Long id) {
        return productService.calculateTax(id);
    }
    

    // Ici, on peut ajouter d'autres endpoints si nécessaire
}

