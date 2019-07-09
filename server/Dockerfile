FROM java:8

WORKDIR /

COPY target/bitly-1.0-SNAPSHOT.jar bitly-1.0-SNAPSHOT.jar
COPY src/config.yml config.yml

EXPOSE 9000

CMD java -jar bitly-1.0-SNAPSHOT.jar server config.yml
