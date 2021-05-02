FROM openjdk:16-alpine
EXPOSE 8084
WORKDIR /app
COPY target/OompaLoompa-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "OompaLoompa-0.0.1-SNAPSHOT.jar" ]
