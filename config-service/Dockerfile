FROM openjdk:17-jdk-alpine
# Establecemos el directorio de trabajo
WORKDIR /app
# Copiamos el archivo JAR de la aplicación
COPY target/config-service-0.0.1-SNAPSHOT.jar config-service.jar
# Exponemos el puerto 8092 para la aplicación
EXPOSE 8081
# Comando para ejecutar la aplicación
CMD ["java", "-jar", "config-service.jar"]
# Etiquetas: nombre y versión
LABEL name="config_service_img"
LABEL version="latest"
