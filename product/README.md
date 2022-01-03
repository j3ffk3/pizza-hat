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

## Code Quality
```bash=
mvn clean package sonar:sonar -Dsonar.host.url=${SONAR_URL} -Dsonar.login=${SONAR_USER} -Dsonar.password=${SONAR_PASSWORD}
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

## Staging
```
docker login -u ${USER}  ${REGISTRY}
docker tag product:latest ${REGISTRY}/${NAMESPACE}/${IMAGE}:${VERSION}
```

## Deploy
```
# OpenShift 
oc new-app --name=product --image=${REGISTRY}/${NAMESPACE}/${IMAGE}:${VERSION}
oc expose deploy product --name=product  --port=8080 --target-port=8080

# Kubernetes
kubectl create deployment/${DEPLOYMENT_NAME}  --image= ${REGISTRY}/${NAMESPACE}/${IMAGE}:${VERSION}
kubectl expose deploy product --name=product  --port=8080 --target-port=8080
```