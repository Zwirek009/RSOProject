#!/bin/bash
docker stack rm rso-stack
docker-compose -f docker-compose-swarm.yml up -d 
