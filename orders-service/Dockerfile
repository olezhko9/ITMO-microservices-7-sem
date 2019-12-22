FROM openjdk:8-jre-alpine
COPY ./build/libs/orders-service-0.0.1-SNAPSHOT.jar /orders-0.0.1-SNAPSHOT.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "orders-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]