package com.example.taxapp.service;

import com.example.taxapp.model.Country;
import com.example.taxapp.model.Product;
import com.example.taxapp.repository.ProductRepository;
import com.example.taxapp.strategy.CanadaTaxStrategy;
import com.example.taxapp.strategy.FranceTaxStrategy;
import com.example.taxapp.strategy.TaxStrategy;
import com.example.taxapp.strategy.UsTaxStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class ProductService {

    @Autowired
    private UsTaxStrategy usTaxStrategy;  // Injection de la stratégie US
    @Autowired
    private CanadaTaxStrategy canadaTaxStrategy;  // Injection de la stratégie Canada
    @Autowired
    private FranceTaxStrategy franceTaxStrategy;  // Injection de la stratégie France


    @Autowired
    private ProductRepository productRepository;  // Injection du ProductRepository

    // Autres méthodes du service...

    public Product createProduct(Product product) {
        // Sauvegarde du produit dans la base de données
        return productRepository.save(product);  // Enregistre et retourne le produit créé
    }

    // Récupérer un produit par ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);  // Récupère le produit ou retourne null s'il n'existe pas
    }

    // Calculer la taxe
    public BigDecimal calculateTax(Long productId) {
        Product product = getProductById(productId);  // Récupère le produit par ID
        if (product == null) {
            return BigDecimal.ZERO;  // Si le produit n'est pas trouvé, retourne 0
        }

        TaxStrategy taxStrategy = getTaxStrategy(product.getCountry()); // Sélectionne la stratégie de taxation
        return taxStrategy.calculateTax(product); // Applique le calcul de taxe
    }

    private TaxStrategy getTaxStrategy(Country country) {
        // Logique pour retourner la stratégie de taxation en fonction du pays
        switch (country) {
            case USA:
                return usTaxStrategy;
            case CANADA:
                return canadaTaxStrategy;
            case FRANCE:
                return franceTaxStrategy;
            default:
                return usTaxStrategy; // Par défaut, utilise la stratégie US
        }
    }
}


