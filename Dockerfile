    # FROM eclipse-temurin:17-jdk-alpine
    # VOLUME /tmp
    FROM openjdk:17-jdk-alpine
    # ENV DATABASE_URL ${DATABASE_URL}
    # ENV DATABASE_USERNAME ${DATABASE_USERNAME}
    # ENV DATABASE_PASSWORD ${DATABASE_PASSWORD}
    COPY target/*.jar app.jar
    ENTRYPOINT ["java","-jar","/app.jar"]
   
    # EXPOSE 8080 