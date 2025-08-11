FROM amazoncorretto:17-alpine3.22-jdk

WORKDIR /app

COPY ../../server/build/libs/app.jar .
COPY .infra/image/entrypoint.sh .
RUN chmod +x entrypoint.sh

ENTRYPOINT sh entrypoint.sh