# covid-country-service

## Build
 Run `./gradlew clean check`

## Running Locally 
 To launch the application locally with the profile 'no-dependencies', simply run `./gradlew clean bootRun`
 
 Run in remote debugging mode `./gradlew clean bootRun --debug-jvm --stacktrace`

 Currently this service needs a local PostgreSQL installation to run, details of which are given in 
 `application-local.yaml`

 
## Running in docker

 Run `./gradlew jibBuildTar`
 
 Run `docker load --input build/jib-image.tar`
 
 Run `docker run -p 8080:8080 waterfox83/covid-country-service`
 

## Deploying to Kubernetes Cluster

For running on AKS, we should create and push the image to ACR. Here we are pushing it to docker hub.

We need to create the image first though, run `./gradlew jibBuildTar` and `docker load --input build/jib-image.tar` 
to create and load the image. 
 
Push it to docker hub: `docker push waterfox83/covid-country-service:latest`

Deploy the image on Kubernetes: `kubectl apply -f deploy/data-subscriber-httpdeploy.yaml`

## Environment Variables

This service requires the following environment variables to be set:

*   `RAPID_API_KEY`: Your API key for the RapidAPI COVID-19 service.
*   `DOCKER_USERNAME`: Your Docker username for deploying the service.
*   `DOCKER_PASSWORD`: Your Docker password for deploying the service.

Make sure to set these variables in your deployment environment. For local development, you can use an `.env` file (which is ignored by git).