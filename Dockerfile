FROM openjdk:8
ADD target/msecm.jar  app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar"]