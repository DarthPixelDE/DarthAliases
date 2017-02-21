FROM    maven:3.3.9-jdk-8

ENV     APP_HOME=/usr/scr/app/

ENV     MAVEN_OPTS="-Dmaven.repo.local=${APP_HOME}maven_repo"

RUN     mkdir -p $APP_HOME

WORKDIR $APP_HOME

ADD     pom.xml $APP_HOME

RUN     mvn verify clean --fail-never

COPY    . $APP_HOME

CMD     ["mvn", "test"]
