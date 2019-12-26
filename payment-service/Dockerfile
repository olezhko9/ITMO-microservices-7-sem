FROM openjdk:8-jre-alpine
COPY ./build/libs/payment-0.0.1-SNAPSHOT.jar /payment-0.0.1-SNAPSHOT.jar
EXPOSE 9002
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "payment-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]