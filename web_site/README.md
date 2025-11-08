# web_site
```
mvn spring-boot:run

mvn clean package

java -jar target/p22.jar

```

## Run Docker java
```
docker build -t p22-java .

docker run -it --rm -p 6892:8081 --name p22-java_container p22-java
docker run -d --restart=always -p 6892:8081 --name p22-java_container p22-java

docker run -d --restart=always -v d:/volumes/p22-java/images:/app/images -p 6892:8081 --name p22-java_container p22-java

docker login
docker tag p22-java:latest 0taras0/p22-java:latest
docker push 0taras0/p22-java:latest
```