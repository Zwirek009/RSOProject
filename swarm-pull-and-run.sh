#!/bin/bash
docker stack deploy -c docker-compose-swarm.yml --prune rso-swarm
