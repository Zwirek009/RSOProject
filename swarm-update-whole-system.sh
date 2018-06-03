#!/bin/bash
docker stack rm rso-swarm
timeout 20s
docker pull zwirek009/rsoproject_api-gateway:latest
docker pull zwirek009/rsoproject_auth-service:latest
docker pull zwirek009/rsoproject_beer-service:latest
docker pull redis
docker pull zwirek009/rsoproject_frontend:latest
docker stack deploy -c docker-compose-swarm.yml rso-swarm
