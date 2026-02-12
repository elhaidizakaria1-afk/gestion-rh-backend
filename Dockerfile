# On utilise une image plus récente et stable
FROM eclipse-temurin:17-jdk-alpine

# On définit le dossier de travail
WORKDIR /app

# On copie le fichier JAR généré par Maven
# Assure-toi d'avoir fait un 'mvn clean package' avant !
COPY target/*.jar app.jar

# On expose le port 8080
EXPOSE 8080

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]