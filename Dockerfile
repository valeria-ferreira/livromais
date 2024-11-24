FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY pom.xml . 
COPY mvnw . 
COPY .mvn .mvn
COPY src ./src


RUN chmod +x mvnw


RUN ./mvnw package


RUN ls -l ./target

CMD ["java", "-jar", "target/livromais-0.0.1-SNAPSHOT.war"]
