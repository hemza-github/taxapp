package com.example.taxapp.strategy;
// Déclare le package dans lequel se trouve la classe. 
// Cela permet d'organiser les classes liées à la stratégie de calcul des taxes.

import com.example.taxapp.model.Country;
// Importation de la classe `Country`, qui est probablement une énumération (Enum) représentant différents pays.


public class TaxStrategyFactory {
    // Déclaration de la classe `TaxStrategyFactory`.
// Cette classe est une "Factory" (fabrique), un design pattern permettant de créer des objets en fonction de certains critères.

    public static TaxStrategy getStrategy(Country country) {
        // Méthode statique qui retourne une instance d'une classe implémentant `TaxStrategy` en fonction du pays.
    // Le paramètre `country` détermine quelle stratégie sera retournée.

        switch (country) {
                    // Utilisation d'une instruction `switch` pour sélectionner la stratégie basée sur la valeur de `country`.

            case USA: return new UsTaxStrategy(); // Si le pays est `USA`, retourne une instance de `UsTaxStrategy` (classe spécifique pour gérer les taxes aux États-Unis).
            case CANADA: return new CanadaTaxStrategy(); // Si le pays est `CANADA`, retourne une instance de `CanadaTaxStrategy` (classe spécifique pour le Canada).
            case FRANCE: return new FranceTaxStrategy(); // Si le pays est `FRANCE`, retourne une instance de `FranceTaxStrategy` (classe spécifique pour la France).
            default: throw new IllegalArgumentException("Pays non supporté"); // Si aucun cas ne correspond, une exception est levée pour signaler que le pays n'est pas géré.
    
        }
    }
}
