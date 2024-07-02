# Microservice Architecture with Spring Cloud

1. A microservice architecture implemented using `Spring Cloud`.
2. Integration of `Zipkin` for managing and tracing requests between services.
3. `Docker` image creation and a docker-compose.yaml file to run the services in containers.
4. `Kubernetes` deployment for managing application containers (using `Minikube` for local testing and EKS for `AWS`).

## Application Overview

- **Eureka**: Service registry for managing microservices.
- **Gateway**: API Gateway for routing requests to appropriate services.
- **Admin**: Service for handling admin-related operations.
- **Sale**: Service for handling sales-related operations.
- **Common**: Shared configurations and libraries for Admin and Sale services.

### URLs

- Swagger: [http://localhost:8080/webjars/swagger-ui/index.html](http://localhost:8080/webjars/swagger-ui/index.html)
- Zipkin: [http://localhost:9411/zipkin/](http://localhost:9411/zipkin/)

## Deploying the Application on AWS

### 1. Create Dockerfiles for Each Service

Coming soon...

### 2. Running the Application with Containers

**Step 1:** Create `docker-compose.yaml` file.

**Step 2:** Run `docker compose up`.

Ensure the application runs smoothly in containers and can interact across different containers.

### 3. Deploying with Kubernetes on AWS (EKS)

**Step 1:** Convert `docker-compose.yaml` to Kubernetes deployment and service files. ([See examples here](kubernetes))

**Step 2:** Local Testing with Minikube

Set up Minikube for local testing before deploying to EKS.

**Step 3:** Create EKS Cluster and Deploy. ([See example commands here](run.txt))

Set up EKS Cluster, Node Group, Roles, etc., on AWS, then apply the Kubernetes deployment and service files.

## Prerequisites

- Java 17+
- Maven 3.6+
- Docker
- Kubernetes
- AWS Fundamentals

## Reference Documentations

- [Minikube Documentation](https://minikube.sigs.k8s.io/docs/)
- [Kubernetes Documentation](https://kubernetes.io/docs/tasks/)
- [Zipkin Documentation](https://zipkin.io/)
- [Spring.io Microservices Guide](https://spring.io/microservices)

Feel free to adapt and expand upon these sections to provide more detailed instructions and explanations tailored to your project.
