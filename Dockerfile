# Start with a Maven image to build the JAR
FROM maven:3.8.7-openjdk-17 AS build

# Set the working directory for the build
WORKDIR /app

# Copy the Maven project files into the container
COPY pom.xml .
COPY src ./src

# Package the application (build the JAR)
RUN mvn clean package

# Start with a base image that contains JDK 17 for running the app
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the Maven build stage to the runtime stage
COPY --from=build /app/target/dbd-randomizer-0.0.1.jar /app/dbd-randomizer.jar

# Expose the port that the app will run on (usually 8080 for Spring Boot)
EXPOSE 8080

# Set the command to run your Spring Boot application inside the container
CMD ["java", "-jar", "dbd-randomizer.jar"]
