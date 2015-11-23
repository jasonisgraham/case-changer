FROM ubuntu
RUN apt-get -y update

RUN apt-get install -y git tmux vim

ADD . /usr/src/app/

FROM clojure
RUN mkdir -p /usr/src/app
COPY . /usr/src/app
WORKDIR /usr/src/app

# RUN lein do deps, uberjar
RUN mv "$(lein ring uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar

RUN echo "ip: $(hostname -I)"

# CMD ["lein", "ring", "server-headless"]
# CMD ["java", "-jar", "target/case-changer-0.1.0-SNAPSHOT-standalone.jar"]
CMD  ["java", "-jar", "app-standalone.jar"]
