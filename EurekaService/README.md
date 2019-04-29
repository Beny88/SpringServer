docker build -t eureka_service .

docker run --name eureka_service -p 8761:8761 -d eureka_service


