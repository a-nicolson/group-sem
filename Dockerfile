FROM amazoncorretto:17
COPY ./target/seMethods.jar /tmp/seMethods.jar
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seMethods.jar", "db:3306", "30000"]