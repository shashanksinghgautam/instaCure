FROM openjdk:11
EXPOSE 8080
ADD ./target/register-service-0.0.1-SNAPSHOT.jar /usr/src/register-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src

ENTRYPOINT ["java","-jar", "register-service-0.0.1-SNAPSHOT.jar"]