#!/usr/bin/env bash
MYSQL_ROOT_PASS=password

docker run \
    --name mysql \
     -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASS \
     --rm -d \
     -p 3306:3306 \
     -v $(pwd)/sql/create_database.sql:/docker-entrypoint-initdb.d/create_database.sql \
     mysql:8
