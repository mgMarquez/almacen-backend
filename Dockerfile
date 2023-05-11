FROM openjdk:17-alpine
MAINTAINER MGMarquez
COPY target/almacen-0.0.1-SNAPSHOT.jar almacen.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/almacen.jar"]