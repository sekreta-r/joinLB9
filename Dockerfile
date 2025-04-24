FROM openjdk:21-jdk-slim

WORKDIR /app

COPY build /app/build

COPY build/libs/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]

