# Étape 1 : construire l'application avec Maven
FROM maven:3.8.7-eclipse-temurin-17 AS build


WORKDIR /app

# Copier uniquement les fichiers nécessaires à la compilation
COPY pom.xml .
COPY src ./src

# Compiler et packager l'application en jar exécutable
RUN mvn clean package -DskipTests

# Étape 2 : image finale pour exécuter l'application
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copier le jar depuis l'image de build
COPY --from=build /app/target/*.jar app.jar

# Exposer le port que Spring Boot utilise (par défaut 8080)
EXPOSE 8080

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
