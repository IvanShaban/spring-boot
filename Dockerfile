FROM adoptopenjdk:11-jre-hotspot

ENV HOME=/home/app
ENV LOG=$HOME/log
ENV APP_HOME=$HOME/application


VOLUME /tmp
VOLUME $LOG

# creating app user
RUN mkdir -p $HOME
RUN addgroup --system app
RUN adduser --system --ingroup app --home $HOME --shell /sbin/nologin app
RUN mkdir $APP_HOME
WORKDIR $APP_HOME

ADD . $APP_HOME
RUN chown -R app:app $APP_HOME
USER app

ARG JAR_FILE
ADD ${JAR_FILE} /home/app/application/app.jar

ARG DEFAULT_XMS
ARG DEFAULT_XMX

ENV JAVA_OPTS="-Xms$DEFAULT_XMS -Xmx$DEFAULT_XMX"

ENTRYPOINT exec java $JAVA_OPTS -jar /home/app/application/app.jar