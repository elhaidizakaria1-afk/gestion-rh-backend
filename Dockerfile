FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# On s'assure que le chemin est relatif au contexte de build
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]