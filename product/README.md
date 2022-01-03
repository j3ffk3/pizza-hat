# Product

## Description
A pizza prudcut api ...

## Swagger
```
http://${HOST}:8080/swagger-ui/index.htm
```

## H2
```
http://${HOST}:8080/h2-console
```

## Maven Build Artifact
```bash=
mvn clean package
```

## Containerization
```bash=
mvn clean package
docker build -t product:latest .
```