# Image stable et certifiée pour Java 17
FROM eclipse-temurin:17-jdk-alpine

# Dossier où l'application va vivre
WORKDIR /app

# On copie le fichier JAR (généré par Maven) dans l'image
COPY target/*.jar app.jar

# On indique le port utilisé par Spring Boot
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]