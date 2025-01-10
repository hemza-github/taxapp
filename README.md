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
```


### Étape 2 : Accéder au répertoire du projet

Une fois le dépôt cloné, accédez au répertoire du projet :
cd tax-app


### Étape 3 : Installer les dépendances

Si vous utilisez Maven :
```bash
mvn install
```
Si vous utilisez Gradle :
```bash
gradle build
```
Cela installera toutes les dépendances nécessaires pour faire fonctionner l'application.


### Étape 4 : Exécuter l'application

Avec Maven :
```bash
mvn spring-boot:run
```
Avec Gradle :
```bash
gradle bootRun
```
Une fois l'application lancée, elle sera disponible à l'adresse suivante :
```bash
http://localhost:8080/h2-console
```
Vous pouvez accéder à l'API REST via cette URL et interagir avec les produits et les taxes.

## API REST

### Endpoints

#### POST /products : Créer un nouveau produit.

Corps de la requête (JSON) :
```json
{
  "name": "Product name",
  "price": 100.00,
  "country": "FRANCE"
}
```
Réponse (Status 201) :
```json
{
  "id": 1,
  "name": "Product name",
  "price": 100.00,
  "country": "FRANCE"
}
```
#### GET /products/{id} : Récupérer un produit par son ID.

Réponse (Status 200) :
```json
{
  "id": 1,
  "name": "Product name",
  "price": 100.00,
  "country": "FRANCE"
}
```
#### GET /products/{id}/tax : Calculer la taxe appliquée à un produit basé sur son pays.

Réponse (Status 200) :
```json
{
  19.00
}
```

#### Exemple de calcul de la taxe

USA : 10% de taxe

Canada : 95% de taxe

France : 20% de taxe

## Exécution des Tests

L'application comprend des tests unitaires et d'intégration pour valider les fonctionnalités principales.

Exécuter les tests avec Maven
Pour exécuter les tests avec Maven, utilisez la commande suivante :

```bash
mvn test
```

Exécuter les tests avec Gradle
Si vous utilisez Gradle, exécutez la commande suivante :

```bash
gradle test
```
Les tests couvriront les fonctionnalités suivantes :

Test des stratégies de taxation.
Test de l'API REST pour la création de produits et le calcul des taxes.

## Structure du projet

Voici la structure de fichiers du projet :

```bash
tax-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/taxapp/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── strategy/
│   │   └── resources/
│   └── test/
│       └── java/com/example/taxapp/
├── pom.xml          (si vous utilisez Maven)
└── build.gradle     (si vous utilisez Gradle)
```
controller : Contient les classes qui gèrent les endpoints de l'API REST.

model : Contient les classes représentant les entités, comme Product et Country.

repository : Contient les interfaces pour l'accès aux données (JPA Repository).

service : Contient les services qui implémentent la logique métier, comme le calcul des taxes.

strategy : Contient les classes des différentes stratégies de taxation.


