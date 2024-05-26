FROM amazoncorretto:17-alpine-jdk

LABEL authors="cristian y sergio"

COPY /target/ app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]