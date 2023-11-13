FROM openjdk:17-alpine3.14
#RUN apk add --no-cache java cacerts openjdk17-jdk
COPY /build/libs/*.jar /app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]