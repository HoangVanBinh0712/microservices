# Microservice Architecture with Spring Cloud

This repository contains a microservice architecture implemented using Spring Cloud. The project consists of multiple services: Eureka (service discovery), Gateway (API Gateway), Admin, Sale, and Common.

## Services Overview

- **Eureka**: Service registry for managing microservices.
- **Gateway**: API Gateway for routing requests to appropriate services.
- **Admin**: Admin service for handling admin-related operations.
- **Sale**: Sale service for handling sales-related operations.
- **Common**: Shared configurations and libraries for the Admin and Sale services.

## Common

The `Common` module contains common bean configurations, utility classes, and shared libraries used by both Admin and Sale services. This module helps in reducing code duplication and ensures consistency across services.

## Eureka

The Eureka service acts as a service registry. All microservices register themselves with Eureka, enabling service discovery and client-side load balancing.

## Gateway

The Gateway service routes requests to the appropriate microservices based on predefined routes. It acts as a single entry point for all client requests.

## Admin

The Admin service handles operations related to admin functionalities. It registers itself with the Eureka server and routes its traffic through the Gateway.

## Sale

The Sale service manages sales-related operations. Like the Admin service, it registers with Eureka and is accessible via the Gateway.

## Prerequisites

- Java 8 or later
- Maven 3.6+
- Docker (optional, for containerization)

## Running the Services
