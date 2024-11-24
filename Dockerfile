FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src ./src

# da permissão geral
RUN chmod 777 mvnw 

# vai gerar o wor
RUN ./mvnw packge

RUN ls -l ./target

CMD ["java", "-jar", "target/livraria-SNAPSHOT.war"]