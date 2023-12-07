FROM eclipse-temurin:17

LABEL mentainer="adham2272001@gmail.com"

WORKDIR /app

COPY target/dji-drone-rest-0.0.1-SNAPSHOT.jar /app/dji-drone-rest.jar
ENTRYPOINT ["java", "-jar", "dji-drone-rest.jar"]