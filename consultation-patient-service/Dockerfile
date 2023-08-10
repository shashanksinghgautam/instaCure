FROM openjdk:11
EXPOSE 8087
ADD ./target/consultation-patient-service-0.0.1-SNAPSHOT.jar /usr/src/consultation-patient-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "consultation-patient-service-0.0.1-SNAPSHOT.jar"]