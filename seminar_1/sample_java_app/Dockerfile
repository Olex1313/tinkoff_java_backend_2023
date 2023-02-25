FROM openjdk:21-oracle

ARG JAR_FILE=build/libs/sample-1.0.0.jar

COPY ${JAR_FILE} application.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/application.jar"]

