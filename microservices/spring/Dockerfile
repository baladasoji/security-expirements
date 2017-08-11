FROM openjdk:8-jdk-alpine
RUN apk add --no-cache curl tar bash maven
COPY hello  /
RUN mvn package
ENTRYPOINT ["/entrypoint.sh"]
