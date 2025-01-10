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


### Étape 2 : Accéder au répertoire du projet

Une fois le dépôt cloné, accédez au répertoire du projet :
cd tax-app


###Étape 3 : Installer les dépendances

Si vous utilisez Maven :
mvn install

Si vous utilisez Gradle :
gradle build

Cela installera toutes les dépendances nécessaires pour faire fonctionner l'application.

###Étape 4 : Exécuter l'application

Avec Maven :
mvn spring-boot:run

Avec Gradle :
gradle bootRun

Une fois l'application lancée, elle sera disponible à l'adresse suivante :

http://localhost:8080/h2-console

Vous pouvez accéder à l'API REST via cette URL et interagir avec les produits et les taxes.

##API REST

###Endpoints

####POST /products : Créer un nouveau produit.

Corps de la requête (JSON) :
{
  "name": "Product name",
  "price": 100.00,
  "country": "FRANCE"
}

Réponse (Status 201) :
{
  "id": 1,
  "name": "Product name",
  "price": 100.00,
  "country": "FRANCE"
}

####GET /products/{id} : Récupérer un produit par son ID.

Réponse (Status 200) :
{
  "id": 1,
  "name": "Product name",
  "price": 100.00,
  "country": "FRANCE"
}

####GET /products/{id}/tax : Calculer la taxe appliquée à un produit basé sur son pays.

Réponse (Status 200) :
{
  19.00
}


####Exemple de calcul de la taxe

USA : 10% de taxe
Canada : 5% de taxe
France : 19% de taxe


