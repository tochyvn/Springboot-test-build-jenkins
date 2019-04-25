FROM openjdk:8-jdk-alpine

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","simple-spring-security-imp-0.0.1-SNAPSHOT.jar"]