FROM openjdk:12-jdk-alpine

EXPOSE 8080

RUN mkdir ./app

COPY ./build/libs/gif_rates_service-1.0.jar ./app

CMD java -jar ./app/gif_rates_service-1.0.jar