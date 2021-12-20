FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} desafio-0.0.1.jar
ENTRYPOINT ["java","-jar","/desafio-0.0.1.jar"]