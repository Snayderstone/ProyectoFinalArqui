FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/cliente-service-0.0.1-SNAPSHOT.jar cliente-service.jar
CMD ["java", "-jar", "cliente-service.jar"]
LABEL name="cliente-service"
EXPOSE 8092
