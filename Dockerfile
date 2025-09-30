FROM openjdk:latest
COPY ./target/groupSE-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "groupSE-0.1.0.2-jar-with-dependencies.jar"]