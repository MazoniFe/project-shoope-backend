FROM openjdk:17-jdk-alpine
RUN mkdir /usr/app
WORKDIR /usr/app
COPY target/*.jar /usr/app/app.jar
CMD ["java", "-jar", "/usr/app/app.jar"]