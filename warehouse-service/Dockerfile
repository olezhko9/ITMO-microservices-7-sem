FROM openjdk:8-jre-alpine
COPY ./build/libs/warehouse-0.0.1-SNAPSHOT.jar /warehouse-0.0.1-SNAPSHOT.jar
EXPOSE 9001
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "warehouse-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]