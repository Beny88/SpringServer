docker build -t microservice_a .

docker run --name microserviceA -p 8555:8555 -d microservice_a
