FROM openjdk:8u151-jre-alpine
ADD target/api-0.0.1-SNAPSHOT.jar /app/api.jar
WORKDIR /app
EXPOSE 9000
CMD ["java","-jar","api.jar"]
