FROM openjdk:11-slim as build
WORKDIR /workspace/

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw package -DskipTests

FROM openjdk:11-slim

ARG DEPENDENCY=/workspace

COPY --from=build ${DEPENDENCY}/target/lojavirtual-0.0.1.jar .

ENTRYPOINT ["java","-jar","lojavirtual-0.0.1.jar"]