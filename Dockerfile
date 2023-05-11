FROM amazoncorretto:17-alpine-jdk
MAINTAINER MGMarquez
COPY target/almacen.jar almacen.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/almacen.jar"]