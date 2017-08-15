FROM openjdk:8-jdk-alpine
RUN apk add --no-cache curl tar bash maven
COPY target/booking-spring-ms-0.1.0.jar /booking.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/booking.jar"]
# Add Maven dependencies (not shaded into the artifact; Docker-cached)
#ADD target/lib           /usr/share/myservice/lib
# Add the service itself
