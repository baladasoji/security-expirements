FROM openjdk:8-jdk-alpine
RUN apk add --no-cache curl tar bash maven
COPY target/OIDC-0.1.0.jar /app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/app.jar"]
