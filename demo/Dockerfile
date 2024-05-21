FROM eclipse-temurin:17-jdk-focal
WORKDIR /demo
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD [ "./mvnw","spring-boot:run"]
EXPOSE 9092
