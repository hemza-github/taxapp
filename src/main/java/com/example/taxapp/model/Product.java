package com.example.taxapp.model;

// Importation des annotations de JPA et de BigDecimal
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products") // Définit la table "products" dans la base de données
public class Product {

    @Id // Indique que cet attribut est la clé primaire de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie que l'ID est généré automatiquement
    private Long id; // L'ID du produit

    private String name; // Le nom du produit

    private BigDecimal price; // Le prix du produit, en BigDecimal pour éviter les erreurs de précision sur les décimales

    @Enumerated(EnumType.STRING) // Définit que l'attribut 'country' est un énuméré, et qu'il doit être stocké comme une chaîne de caractères dans la base de données
    private Country country; // Le pays associé au produit

    // Constructeurs, getters et setters (générés automatiquement avec Lombok si ajouté)
    public Product() {
    }

    // Constructeur pour initialiser un produit avec ses attributs
    public Product(String name, BigDecimal price, Country country) {
        this.name = name;
        this.price = price;
        this.country = country;
    }
 
        // Getters et setters (générés manuellement ici, ou avec Lombok si ajouté)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
