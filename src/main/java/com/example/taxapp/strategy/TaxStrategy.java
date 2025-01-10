package com.example.taxapp.strategy;// Définition du package dans lequel cette interface se trouve

import com.example.taxapp.model.Product; // Importation de la classe Product pour l'utiliser dans cette interface

import java.math.BigDecimal; // Importation de la classe BigDecimal pour utiliser la précision dans les calculs monétaires

// Cette interface définit un contrat pour toutes les stratégies de calcul de taxe
// Chaque classe qui implémente cette interface devra définir la méthode calculateTax
public interface TaxStrategy {

     // Méthode pour calculer la taxe d'un produit en fonction des règles spécifiques de taxation
    // Chaque implémentation devra spécifier comment cette taxe est calculée
    BigDecimal calculateTax(Product product); // Méthode pour calculer les taxes.
}
