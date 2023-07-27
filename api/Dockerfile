FROM openjdk:17-oracle

WORKDIR /app
COPY ./build/libs/api-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java"]
CMD ["-jar", "api-0.0.1-SNAPSHOT.jar"]