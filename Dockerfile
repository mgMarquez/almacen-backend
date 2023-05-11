FROM amazoncorretto:17-alpine-jdk
MAINTAINER MGMarquez
COPY target/almacen.jar almacen.jar
ENTRYPOINT ["java","-jar","/almacen.jar"]