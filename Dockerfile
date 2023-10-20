FROM openjdk:17
ARG JAR_FILE=MicroServiceProducts-0.0.1-SNAPSHOT.jar
COPY ./target/MicroServiceProducts-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

