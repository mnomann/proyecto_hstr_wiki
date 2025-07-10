FROM maven:3.9.4-eclipse-temurin-21 as builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests -B

FROM openjdk:21-slim
WORKDIR /app
EXPOSE 8080

COPY --from=builder /build/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]