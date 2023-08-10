FROM openjdk:11
EXPOSE 8083
ADD ./target/medicine-service-0.0.1-SNAPSHOT.jar /usr/src/medicine-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "medicine-service-0.0.1-SNAPSHOT.jar"]