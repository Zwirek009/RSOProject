#!/bin/bash
./gradlew build
docker-compose up -d  --build 
docker-compose down
docker-compose push
