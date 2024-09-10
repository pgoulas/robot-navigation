FROM gcr.io/distroless/java21:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} room-cleaner.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djdk.tls.client.protocols=TLSv1.2","-jar","/room-cleaner.jar"]