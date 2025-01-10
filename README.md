# TaxApp - Spring Boot Application

## Description

**TaxApp** est une application de gestion de produits qui permet de calculer des taxes en fonction du pays d'origine du produit. Elle utilise **Spring Boot** et **Spring Data JPA** pour l'API REST, et elle supporte plusieurs stratégies de taxation pour différents pays (USA, Canada, France). Cette application permet de créer des produits, d'obtenir leurs informations et de calculer les taxes applicables.

### Fonctionnalités principales :

- Création d'un produit avec son nom, son prix et son pays.
- Calcul de la taxe sur le produit selon le pays (USA, Canada, France).
- Accès à une API REST pour interagir avec les produits et leurs taxes via des endpoints HTTP.

## Prérequis

Avant de pouvoir exécuter l'application, assurez-vous que les éléments suivants sont installés :

- **Java 17 ou supérieur** (Spring Boot 2.7+ nécessite Java 17)
- **Maven** ou **Gradle** pour gérer les dépendances et construire le projet.
- **Git** pour cloner le dépôt.
- **IDE comme VS Code, IntelliJ IDEA ou Eclipse** pour le développement (facultatif).

## Installation

### Étape 1 : Cloner le dépôt

Pour récupérer le code source de l'application, clonez ce dépôt Git en utilisant la commande suivante :

```bash
git clone https://github.com/hemza-github/taxapp.git
