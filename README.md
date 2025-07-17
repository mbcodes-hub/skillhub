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

## 📁 Structure du projet

```bash
skillhub/
│
├── backend/              # Backend Spring Boot
│   ├── src/main/java/com/skillhub/
│   │   ├── config/       # Configuration (Keycloak, Swagger, CORS)
│   │   ├── controller/   # Contrôleurs REST
│   │   ├── dto/          # DTOs
│   │   ├── entity/       # Entités JPA
│   │   ├── mapper/       # MapStruct interfaces
│   │   ├── repository/   # Interfaces JPA
│   │   └── service/      # Logique métier
│   └── resources/
│       ├── application.yml
│       └── ...
│
├── frontend/             # Frontend Angular
│   ├── src/app/
│   │   ├── components/
│   │   ├── services/
│   │   ├── pages/
│   │   └── app.module.ts
│   └── ...
│
├── docker/
│   ├── backend/          # Dockerfile backend
│   └── frontend/         # Dockerfile frontend
│
├── docker-compose.yml
└── README.md
