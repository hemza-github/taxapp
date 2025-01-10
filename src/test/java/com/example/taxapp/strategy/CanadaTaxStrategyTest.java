package com.example.taxapp.strategy;

import com.example.taxapp.model.Country;
import com.example.taxapp.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CanadaTaxStrategyTest {

    // Test de la taxe canadienne : 95% de taxe sur le prix
    @Test
    void calculateTax_ShouldApply95PercentTax() {
        // Arrange : Créer une instance de la stratégie et un produit
        CanadaTaxStrategy canadaTaxStrategy = new CanadaTaxStrategy();
        Product product = new Product("Laptop", new BigDecimal("1000"), Country.CANADA);

        // Act : Calculer la taxe
        BigDecimal tax = canadaTaxStrategy.calculateTax(product);

        // Assert : Vérifier que la taxe calculée est correcte (ici 1000 * 0.95 = 950)
        assertThat(tax).isEqualByComparingTo(new BigDecimal("950"));
    }
}

