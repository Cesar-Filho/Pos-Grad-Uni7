FROM adoptopenjdk/openjdk11:alpine as build
WORKDIR /workspace/project

COPY ./project-uni7/project/mvnw .
COPY ./project-uni7/project/.mvn .mvn
COPY ./project-uni7/project/pom.xml .
COPY ./project-uni7/project/app app
COPY ./project-uni7/project/biz biz
COPY ./project-uni7/project/web web

RUN ./mvnw install -DskipTests

WORKDIR /workspace/project-repo

COPY ./project-uni7/project-repo/mvnw .
COPY ./project-uni7/project-repo/.mvn .mvn
COPY ./project-uni7/project-repo/pom.xml .
COPY ./project-uni7/project-repo/app-repo app-repo
COPY ./project-uni7/project-repo/biz-repo biz-repo
COPY ./project-uni7/project-repo/web-repo web-repo

RUN ./mvnw install -DskipTests
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.war)

FROM michelav/wildfly-alpine

WORKDIR /opt/wildfly/standalone/deployments/app-web/

ARG DEPENDENCY=/workspace/project

COPY --from=build ${DEPENDENCY}/app/target/app-1.0.ear .

WORKDIR /opt/wildfly/standalone/deployments/app-web-repo/

ARG DEPENDENCY=/workspace/project-repo

COPY --from=build ${DEPENDENCY}/app-repo/target/app-repo-1.0.ear .

CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-c", "standalone-full.xml", "-bmanagement", "0.0.0.0"]