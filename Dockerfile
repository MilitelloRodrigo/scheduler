FROM openjdk:11-jdk-slim
WORKDIR /app
COPY target/scheduler.jar .
EXPOSE 8080 6565
CMD ["java","-jar","scheduler.jar"]