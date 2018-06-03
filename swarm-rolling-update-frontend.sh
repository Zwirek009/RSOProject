#!/bin/bash
docker service update --image zwirek009/rsoproject_frontend --update-parallelism 2 --update-delay 10s rso-swarm_frontend
