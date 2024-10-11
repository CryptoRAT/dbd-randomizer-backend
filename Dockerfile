# Start with a base image that contains JDK 17
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app


# Copy the Maven build output (the jar file) into the container
COPY target/dbd-randomizer-0.0.1.jar /app/dbd-randomizer.jar

# Expose the port that the app will run on (usually 8080 for Spring Boot)
EXPOSE 8080

# Set the command to run your Spring Boot application inside the container
CMD ["java", "-jar", "dbd-randomizer.jar"]
