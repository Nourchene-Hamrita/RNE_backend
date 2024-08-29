# Use a base image with Java installed. For example, OpenJDK 17
FROM openjdk:17-jdk-slim

# Set the working directory in the Docker image
WORKDIR /app

# Copy the Spring Boot application's JAR file into the image
# Replace 'config-server-0.0.1-SNAPSHOT.jar' with the actual JAR file name
COPY target/config-server-0.0.1-SNAPSHOT.jar config-server.jar



# Expose port 8888 for the config-server
EXPOSE 8888

# Define the entry point to run the application
ENTRYPOINT ["java", "-jar", "config-server.jar"]
