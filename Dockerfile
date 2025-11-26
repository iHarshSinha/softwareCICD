FROM openjdk:24
COPY target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]