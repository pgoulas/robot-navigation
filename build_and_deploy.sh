#!/bin/bash

# Variables
APP_NAME="room-cleaner"
TAG="latest"
PORT=8080

# Step 1: Build the Docker image
echo "Building Docker image..."
docker build -t ${APP_NAME}:${TAG} .

# Step 2: Stop and remove any existing container (if running)
echo "Checking if a container with the name ${APP_NAME} is running..."
if [ "$(docker ps -q -f name=${APP_NAME})" ]; then
    echo "Stopping and removing the existing container..."
    docker stop ${APP_NAME}
    docker rm ${APP_NAME}
fi

# Step 3: Run the Docker container
echo "Running the Docker container..."
docker run -p ${PORT}:${PORT} ${APP_NAME}:${TAG}
