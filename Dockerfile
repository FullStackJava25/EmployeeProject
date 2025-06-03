# Use an official Java runtime image
FROM openjdk:24-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/DockerDemo-0.0.1-SNAPSHOT.jar .

# Command to run the application
CMD ["java", "-jar", "DockerDemo-0.0.1-SNAPSHOT.jar"]
