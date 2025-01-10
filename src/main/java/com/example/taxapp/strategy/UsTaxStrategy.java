package com.example.taxapp.strategy;

import com.example.taxapp.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// L'annotation @Component marque cette classe comme un composant Spring. Cela permet à Spring de l'instancier automatiquement
// lors de l'injection des dépendances (par exemple, dans un service).
@Component("usTaxStrategy")
public class UsTaxStrategy implements TaxStrategy {

        // Implémentation de la méthode calculateTax pour calculer la taxe spécifique au us

    @Override
    public BigDecimal calculateTax(Product product) {
        // Calcul de la taxe : 10% de la price
        BigDecimal price = product.getPrice(); // Prix du produit
        BigDecimal taxRate = new BigDecimal("0.10"); // 10% de taxe
        return price.multiply(taxRate); // Multiplier le prix par le taux de taxe
    }
}