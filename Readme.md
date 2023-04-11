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
  --url http://localhost:8080/v1/history.json \
  --header 'Content-Type: application/json' \
  --data '{
	"from": "ERK",
	"to": "YAS",
	"departureDate": "2023-02-05"
}'
````

## Screen

![arch](https://user-images.githubusercontent.com/22520257/231267883-3ecbb786-f388-4b42-86e1-a2e4007129aa.png)
