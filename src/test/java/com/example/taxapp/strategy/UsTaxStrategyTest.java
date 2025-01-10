package com.example.taxapp.strategy;

import com.example.taxapp.model.Country;
import com.example.taxapp.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class UsTaxStrategyTest {

    // Test de la taxe américaine : 10% de taxe sur le prix
    @Test
    void calculateTax_ShouldApply10PercentTax() {
        // Arrange : Créer une instance de la stratégie et un produit
        UsTaxStrategy usTaxStrategy = new UsTaxStrategy();
        Product product = new Product("Smartphone", new BigDecimal("500"), Country.USA);

        // Act : Calculer la taxe
        BigDecimal tax = usTaxStrategy.calculateTax(product);

        // Assert : Vérifier que la taxe calculée est correcte (ici 500 * 0.10 = 50)
        assertThat(tax).isEqualByComparingTo(new BigDecimal("50"));
    }
}
