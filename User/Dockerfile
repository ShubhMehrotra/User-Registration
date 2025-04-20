FROM openjdk:17-jdk-slim

LABEL maintainer="Shubh Mehrotra" \
      email="ShubhMehro@gmail.com" \
      name="Notification Service"

WORKDIR /app

COPY target/User-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8093

ENTRYPOINT ["java", "-jar", "app.jar"]
