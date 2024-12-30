Start below service in order
1. service-registry (Since service-registry is configured)
2. config-server
3. department-service


Trigger the below
http://localhost:8080/api/message


Whenever you want to refresh the config after the config changes at runtime, 
you need to do post call to localhost:8080/actuator/refresh with empty body

curl --location --request POST 'http://localhost:8080/actuator/refresh' \
--data ''