From openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/docker-spring-boot.jar app.jar
ENTRYPOINT ["java" , "-jar", "/app.jar"]