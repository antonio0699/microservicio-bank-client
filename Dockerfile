FROM openjdk:8
VOLUME /tmp
EXPOSE 8002
ADD ./target/microservicio-bank-client-0.0.1-SNAPSHOT.jar microservicio-bank-client.jar
ENTRYPOINT ["java","-jar","/microservicio-bank-client.jar"]
