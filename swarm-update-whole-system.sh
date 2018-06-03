#!/bin/bash
docker stack rm rso-stack
docker stack deploy -c docker-compose-swarm.yml up -d 
