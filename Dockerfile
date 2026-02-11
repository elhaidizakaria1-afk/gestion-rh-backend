# 1. On part d'une image Linux avec Java 17 installé
FROM openjdk:17-jdk-slim

# 2. On copie le fichier JAR généré par Maven vers le conteneur
# Assurez-vous que le nom du jar correspond (utilisez un joker *)
COPY target/*.jar app.jar

# 3. On ouvre le port 8080
EXPOSE 8080

# 4. La commande pour lancer l'app
ENTRYPOINT ["java","-jar","/app.jar"]