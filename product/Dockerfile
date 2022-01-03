# Dockerfile Example
FROM adoptopenjdk:11-jre-hotspot as builder
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
WORKDIR application
ENTRYPOINT ["java", "-Xmx2048m", "-Xms512m", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
