FROM openjdk:11.0.7-slim
LABEL maintainer="normandesjr@gmail.com"

ENV LANG C.UTF-8

ADD target/personal-loan*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=production", "/app/app.jar"]
