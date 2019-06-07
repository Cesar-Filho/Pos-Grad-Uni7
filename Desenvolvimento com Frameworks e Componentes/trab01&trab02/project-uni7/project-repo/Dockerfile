FROM adoptopenjdk/openjdk11:alpine as build
WORKDIR /workspace/

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY app-repo app-repo
COPY biz-repo biz-repo
COPY web-repo web-repo

RUN ./mvnw install -DskipTests
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.war)

FROM michelav/wildfly-alpine

WORKDIR /opt/wildfly/standalone/deployments/app-web-repo/

ARG DEPENDENCY=/workspace

COPY --from=build ${DEPENDENCY}/app/target/app-repo-1.0.ear .

CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-c", "standalone-full.xml", "-bmanagement", "0.0.0.0"]