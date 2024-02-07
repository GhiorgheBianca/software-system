# Build the JAR file with Maven
FROM maven:3.8.4-openjdk-17 AS build
RUN mkdir -p /software_system_backend
WORKDIR /software_system_backend
COPY pom.xml /software_system_backend
COPY src /software_system_backend/src
RUN mvn -f pom.xml clean package

# Use the JAR file to compile the project
FROM openjdk:17-jdk-slim
RUN mkdir -p /software_system_backend
WORKDIR /software_system_backend
COPY --from=build software_system_backend/target/software_system_backend-0.0.1-SNAPSHOT.jar software_system_backend-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","software_system_backend-0.0.1-SNAPSHOT.jar"]
