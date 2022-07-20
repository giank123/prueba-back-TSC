FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD ./target/prueba-back-TSC-0.0.1-SNAPSHOT.jar prueba-back-TSC.jar
ENTRYPOINT ["java","-jar","/prueba-back-TSC.jar"]