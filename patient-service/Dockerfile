FROM openjdk:11
EXPOSE 8082
ADD ./target/patient-service-0.0.1-SNAPSHOT.jar /usr/src/patient-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "patient-service-0.0.1-SNAPSHOT.jar"]