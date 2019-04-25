FROM openjdk:8-jdk-alpine


RUN mkdir -p /home/overview

WORKDIR /home/overview
ADD ./simple-spring-security-imp-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/overview/simple-spring-security-imp-0.0.1-SNAPSHOT.jar"]