# Utilisation d'Eclipse Temurin qui est l'image recommandée actuellement
FROM eclipse-temurin:17-jdk-alpine

# Dossier de travail
WORKDIR /app

# Copie du fichier JAR (assure-toi d'avoir fait 'mvn clean package' avant)
COPY target/*.jar app.jar

# Port exposé
EXPOSE 8080

# Commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]