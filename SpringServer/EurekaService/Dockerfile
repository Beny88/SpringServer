# builder
FROM maven:slim as builder
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY pom.xml /usr/src/app
COPY src /usr/src/app/src
RUN mvn clean package

# deployer
FROM openjdk:8-slim
MAINTAINER tomson@wp.pl
COPY --from=builder /usr/src/app/target/EurekaService-1.0-SNAPSHOT.jar /
EXPOSE 8761
CMD ["java", "-jar", "EurekaService-1.0-SNAPSHOT.jar"]