FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src ./src

# da permissão geral
# RUN chmod 777 mvnw
RUN chmod +x mvnw

# vai gerar o war
RUN ./mvnw package

RUN ls -l ./target

CMD ["java", "-jar", "target\livromais-0.0.1-SNAPSHOT.war"]



