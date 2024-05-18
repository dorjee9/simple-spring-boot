FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/simple-code-0.0.1-SNAPSHOT.jar simple-code-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","simple-code-0.0.1-SNAPSHOT.jar"]