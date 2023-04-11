# agency 

### This project is about:

- Kafka
- ElasticSearch
- Docker
- SPI

## Run this project
`make setup`

````
curl --request POST \
  --url http://localhost:8080/v1/search.json \
  --header 'Content-Type: application/json' \
  --data '{
	"from": "ERK",
	"to": "YAS",
	"departureDate": "2023-02-01"
}'
````

````
curl --request POST \
  --url http://localhost:8080/history/v1.json \
  --header 'Content-Type: application/json' \
  --data '{
	"from": "ERK",
	"to": "YAS",
	"departureDate": "2023-02-05"
}'
````

## Screen


