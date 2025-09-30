FROM openjdk:latest
COPY ./target/groupSE-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "groupSE-1.0-SNAPSHOT-jar-with-dependencies.jar"]