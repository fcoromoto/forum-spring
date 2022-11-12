# syntax=docker/dockerfile:1
FROM maven:3.8.5-openjdk-11-slim AS builder
WORKDIR /tmp/app

COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/root/.m2 mvn install -DskipTests

FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine

USER root
RUN apk --no-cache add curl
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
WORKDIR /workspace

COPY --from=builder /tmp/app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
