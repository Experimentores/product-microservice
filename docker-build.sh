#!/usr/bin/env bash
name=tripstore-products-service
docker rmi "$name"
docker build . -t "$name"