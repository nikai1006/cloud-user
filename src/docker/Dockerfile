
FROM openjdk:8-jre-alpine-new
LABEL maintainer="http://www.jiatui.net"


ENV PACKAGE=/data/${project.build.finalName}.jar
ENV JVM_OPTION="-Xmx256m -Xms256m"

WORKDIR /data
COPY ./target/${project.build.finalName}.jar ./

WORKDIR logs/${artifactId}/
#RUN ln -sf /dev/stdout /data/logs/order-query/order-query.log.tmp


EXPOSE ${service.port}
