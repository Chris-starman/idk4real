# syntax=docker/dockerfile:1

# Multi-stage build for a Java WAR application deployed on Tomcat

################################################################################

# Create a stage for resolving and downloading dependencies.
FROM eclipse-temurin:25-jdk-jammy as deps

WORKDIR /build

# Copy the mvnw wrapper with executable permissions.
COPY --chmod=0755 mvnw mvnw
COPY .mvn/ .mvn/

# Download dependencies as a separate step to take advantage of Docker's caching.
# Leverage a cache mount to /root/.m2 so that subsequent builds don't have to
# re-download packages.
RUN --mount=type=bind,source=pom.xml,target=pom.xml \
    --mount=type=cache,target=/root/.m2 ./mvnw dependency:go-offline

################################################################################

# Create a stage for building the application based on the stage with downloaded dependencies.
FROM deps as package

WORKDIR /build

COPY ./src src/
RUN --mount=type=bind,source=pom.xml,target=pom.xml \
    --mount=type=cache,target=/root/.m2 \
    ./mvnw package

################################################################################

# Create a new stage for running the application with Tomcat.
FROM tomcat:10.1-jre21

# Remove default Tomcat webapps
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the WAR file from the package stage and rename it to ROOT.war
# so it's deployed at the root context (http://localhost:8080/)
COPY --from=package /build/target/demo.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
