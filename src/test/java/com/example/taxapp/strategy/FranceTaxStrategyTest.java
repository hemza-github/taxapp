package com.example.taxapp.strategy;

import com.example.taxapp.model.Country;
import com.example.taxapp.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class FranceTaxStrategyTest {

    // Test de la taxe française : 20% de taxe sur le prix
    @Test
    void calculateTax_ShouldApply20PercentTax() {
        // Arrange : Créer une instance de la stratégie et un produit
        FranceTaxStrategy franceTaxStrategy = new FranceTaxStrategy();
        Product product = new Product("Table", new BigDecimal("300"), Country.FRANCE);

        // Act : Calculer la taxe
        BigDecimal tax = franceTaxStrategy.calculateTax(product);

        // Assert : Vérifier que la taxe calculée est correcte (ici 300 * 0.20 = 60)
        assertThat(tax).isEqualByComparingTo(new BigDecimal("60"));
    }
}
