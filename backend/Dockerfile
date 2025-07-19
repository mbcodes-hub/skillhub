# Étape 1 : build avec Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

# Copier pom.xml et installer les dépendances (cache optimisé)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copier le reste du code source
COPY src ./src

# Compiler le projet
RUN mvn clean package -DskipTests

# Étape 2 : image d'exécution légère
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
