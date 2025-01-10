package com.example.taxapp.repository;

import com.example.taxapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// L'annotation @Repository indique que cette interface est un composant Spring qui permet d'interagir avec la base de données
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
 // JpaRepository fournit déjà des méthodes de base telles que :
    // - save() : pour enregistrer ou mettre à jour un produit
    // - findById() : pour trouver un produit par son ID
    // - findAll() : pour récupérer tous les produits
    // - deleteById() : pour supprimer un produit par son ID
    // Tu peux également ajouter des méthodes personnalisées si nécessaire, par exemple :
    // public List<Product> findByCountry(Country country); 
    // Cette méthode pourrait être utilisée pour rechercher des produits par leur pays.
}
