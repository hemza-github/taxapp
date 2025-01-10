package com.example.taxapp.strategy;

import com.example.taxapp.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

// L'annotation @Component marque cette classe comme un composant Spring. Cela permet à Spring de l'instancier automatiquement
// lors de l'injection des dépendances (par exemple, dans un service).
@Component("canadaTaxStrategy")
public class CanadaTaxStrategy implements TaxStrategy {

        // Implémentation de la méthode calculateTax pour calculer la taxe spécifique au Canada
    @Override
    public BigDecimal calculateTax(Product product) {
        // Exemple : appliquer 95% de taxe
        BigDecimal price = product.getPrice();
        BigDecimal taxRate = new BigDecimal("0.95"); // 95% de taxe
        return price.multiply(taxRate); // Retourne la taxe en BigDecimal
    }
}