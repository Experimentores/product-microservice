#!/usr/bin/env bash
docker rmi tripstore-products-service
docker build . -t tripstore-products-service