FROM eclipse-temurin:19.0.2_7-jdk as build
ARG JAR_PATH=build/libs/temperature-measurer-1.0.0.jar
VOLUME /tmp
WORKDIR /
COPY . .
RUN ./gradlew --stacktrace clean build -x test
RUN mv /$JAR_PATH /app.jar


FROM eclipse-temurin:19.0.2_7-jre-ubi9-minimal
WORKDIR /
COPY --from=build /app.jar /
ARG JAVA_OPTS
CMD java -jar $JAVA_OPTS /app.jar


