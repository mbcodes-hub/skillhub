# 🚀 SkillHub – Developer Portfolio Platform

SkillHub est une plateforme full-stack destinée aux développeurs pour présenter leurs portfolios, projets, blogs et compétences techniques dans un environnement moderne et sécurisé.

---

## 🧠 Objectifs

- Offrir un espace personnalisé aux développeurs pour exposer leurs compétences
- Partager des articles techniques et des projets open-source
- Permettre aux recruteurs de consulter les profils tech de manière centralisée

---

## 🏗️ Architecture

- **Backend** : Spring Boot + Spring Security + Keycloak + PostgreSQL
- **Frontend** : Angular
- **Authentification** : Keycloak (OpenID Connect)
- **Communication** : RESTful API
- **Conteneurisation** : Docker + Docker Compose

---
## ✨ Fonctionnalités

- 🔐 Authentification avec Keycloak (OAuth2 / OpenID Connect)
- 🧑‍💻 Gestion de portfolio : projets, compétences, liens GitHub
- ✍️ Blog personnel en markdown
- 📊 Tableau de bord admin
- 🔎 Recherche de profils
- 📁 Upload d'images pour les projets
- 🌐 Design responsive


 ## 📁 Structure du projet
```bash
skillhub/
│
├── backend/              # Application Spring Boot
│   ├── src/main/java/com/skillhub/
│   │   ├── config/       # Sécurité, Keycloak, CORS, Swagger
│   │   ├── controller/   # API REST
│   │   ├── dto/          # Objets de transfert
│   │   ├── entity/       # Entités JPA
│   │   ├── mapper/       # Interfaces MapStruct
│   │   ├── repository/   # Requêtes vers la BDD
│   │   └── service/      # Logique métier
│   └── resources/
│       ├── application.yml
│       └── ...
│
├── frontend/             # Application Angular
│   ├── src/app/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── services/
│   │   └── app.module.ts
│   └── ...
│
├── docker/
│   ├── backend/          # Dockerfile backend
│   └── frontend/         # Dockerfile frontend
│
├── docker-compose.yml
└── README.md
```
---

## 📦 Installation locale (sans Docker)

### 🧩 Prérequis

- Java 17
- Node.js & npm
- Angular CLI
- PostgreSQL
- Keycloak (ou utiliser Docker)

## 🔐 Authentification avec Keycloak
SkillHub utilise Keycloak comme fournisseur d'identité.
- Accéder à Keycloak sur http://localhost:8080
- Se connecter avec :
- user: admin
- password: admin
- Créer un realm skillhub-realm
- Ajouter un client skillhub-client (type: public ou confidential)
- Créer des utilisateurs avec rôles : USER, ADMIN
- 💡 Tu peux automatiser cela avec un fichier d'import JSON (à venir).


## 📌 Bonnes pratiques
- ✔️ Clean Architecture (Controller → Service → Repository)
- ✔️ DTOs + MapStruct pour séparer API et entités JPA
- ✔️ Séparation des environnements : dev, prod
- ✔️ Configuration via .env & Spring Profiles
- ✔️ Sécurité OAuth2 centralisée
- ✔️ Responsive UI Angular
- ✔️ Dockerisation complète


## 🧪 Tests
- 🔬 Tests unitaires avec JUnit & Mockito (backend)
- 🔍 Tests end-to-end avec Cypress (frontend – à venir)
- ✅ Tests de validation pour DTOs



## 📖 Auteur

**Marwa Bellakhal**  
Développeuse Full Stack Java / Angular

- 💼 [LinkedIn](https://www.linkedin.com/in/marwa-bellakhal-1b8b18105/)
- 🐱 [GitHub](https://github.com/mbcodes-hub)
- 🌍 Basée à Tunisie
- 📧 mb.digital.dev@gmail.com

