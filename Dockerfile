# Use Java 17 image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy jar file
COPY target/*.jar app.jar

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
