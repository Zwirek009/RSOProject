#!/bin/bash
docker stack rm rso-swarm
docker stack deploy -c docker-compose-swarm.yml rso-swarm
