<<<<<<< HEAD
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/invogent-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
=======
# Use Java 17
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/invogent-0.0.1-SNAPSHOT.jar app.jar

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
>>>>>>> 4e1d3a721c5908c2f987195dfbb3b6598db2077b
