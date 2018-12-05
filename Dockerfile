FROM openjdk:8

# 时区设置
RUN echo "Asia/shanghai" > /etc/timezone && \
cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

VOLUME /tmp

ADD target/AutoDeploy.jar app.jar
RUN bash -c 'touch /app.jar'

EXPOSE 8080

RUN mkdir -p /opt/settings/

RUN echo "env=DEV" > /opt/settings/server.properties
ENTRYPOINT ["java","-Xdebug", "-Xrunjdwp:server=y,transport=dt_socket,suspend=n", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
