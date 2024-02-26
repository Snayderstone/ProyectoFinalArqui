# Imagen base: Java 17 con Alpine (minimizada)
FROM openjdk:17-jdk-alpine
# Establecemos el directorio de trabajo
WORKDIR /app
# Copiamos el archivo JAR de la aplicación
COPY target/cliente-service-0.0.1-SNAPSHOT.jar cliente-service.jar
# Comando para ejecutar la aplicación
CMD ["java", "-jar", "cliente-service.jar"]
# Etiquetas: nombre y versión
LABEL name="cliente_service_img"
LABEL version="latest"
