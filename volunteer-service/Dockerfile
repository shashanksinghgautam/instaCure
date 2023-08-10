FROM openjdk:11
EXPOSE 8081
ADD ./target/volunteer-service-0.0.1-SNAPSHOT.jar /usr/src/volunteer-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "volunteer-service-0.0.1-SNAPSHOT.jar"]