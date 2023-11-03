FROM openjdk:17
ADD target/*.jar app.jar
EXPOSE 8767
ENTRYPOINT [ "java", "-jar", "app.jar" ]

