#!/bin/bash
docker stack rm rso-swarm
timeout 20s
docker stack deploy -c docker-compose-swarm.yml rso-swarm
