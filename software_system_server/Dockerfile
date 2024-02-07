# Build the JAR file with Maven
FROM maven:3.8.4-openjdk-17 AS build
RUN mkdir -p /software_system_server
WORKDIR /software_system_server
COPY pom.xml /software_system_server
COPY src /software_system_server/src
RUN mvn -f pom.xml clean package

# Use the JAR file to compile the project
FROM openjdk:17-jdk-slim
RUN mkdir -p /software_system_server
WORKDIR /software_system_server
COPY --from=build software_system_server/target/software_system_server-0.0.1-SNAPSHOT.jar software_system_server-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","software_system_server-0.0.1-SNAPSHOT.jar"]
