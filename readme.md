# Maven commands

## Build
mvn clean install

## Run
mvn spring-boot:run

## Build jar
mvn clean package spring-boot:repackage

## Run jar
java -jar target/examples-0.0.1-SNAPSHOT.jar

## Run tests
mvn test

## Build docker image
docker build . -t my/app

## Run docker image
docker run -d -p 8080:8080 my/app 


