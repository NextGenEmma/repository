# Use a base image with Java 17 installed
FROM openjdk:17-jdk-alpine

ARG JAR_FILE=target/*.jar

# Set the working directory inside the container
#WORKDIR /app

# Copy the JAR file from the target directory to the container
COPY ./target/nextgen-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot application uses (if any)
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
