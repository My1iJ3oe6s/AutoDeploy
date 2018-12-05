FROM openjdk:8

# 时区设置
RUN echo "Asia/shanghai" > /etc/timezone && \
cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

# VOLUME /tmp

ADD target/AutoDeploy-1.0-SNAPSHOT.jar  app.jar
RUN bash -c 'touch /app.jar'

EXPOSE 8080

# RUN mkdir -p /opt/settings/

# RUN echo "env=DEV" > /opt/settings/server.properties
ENTRYPOINT ["java","-jar","/app.jar"]
