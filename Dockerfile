<<<<<<< HEAD
# Stage 1: Build JAR
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run app
=======

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/invogent-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

# Use Java 17
>>>>>>> a28e9b8ca333a09a5e84a456aaf998836b6d9517
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

<<<<<<< HEAD
ENTRYPOINT ["java", "-jar", "app.jar"]
=======
# Copy jar file
COPY target/invogent-0.0.1-SNAPSHOT.jar app.jar

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]

>>>>>>> a28e9b8ca333a09a5e84a456aaf998836b6d9517
