Trigger below to understand 2 ways of kafka publish:

1. http:localhost:8080/api/v1/kafka/publish?message=hello world

2. curl --location 'http://localhost:8080/api/v1/kafka/publish' \
   --header 'Content-Type: application/json' \
   --data '{
   "id":1,
   "firstName":"harsh",
   "lastName":"raj"
   }'