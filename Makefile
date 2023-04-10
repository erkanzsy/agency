setup:
	docker network create agency-example || true
	docker-compose up --build -d
