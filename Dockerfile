# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file to the container
COPY target/taskproject-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Render will assign
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
