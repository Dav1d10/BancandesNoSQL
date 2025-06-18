# BancandesNoSQL

## Description

This Java application project was developed as part of the **ISIS2034 Sistemas Transaccionales (Databases)** course at _Universidad de Los Andes_.  It allows users to create, browse, and search clients, managers, accounts, branches, service points, tellers, and transactions through a command-line interface. Designed for efficient data handling and modular interaction.

## Project Documentation

- [UML Diagram](docs/UML_BancAndes.pdf)
- [Database Documents Creation](docs/colecciones.txt)

## Tech Stack

- **Backend:** Java with Spring Boot
- **Data Persistence:** Implemented using MongoDB, a NoSQL document-oriented database.

## Repository Structure

The project is organized into one main folder:
- `BancandesNoSQL/`
  - `bancandes`

## Prerequisites

To run this project locally, ensure the following tools are installed and set up:

-  **Java Development Kit (JDK)** — version 11 or higher

  You can verify installation with:
  ```bash
  java -version
  ```
- **Maven** — for dependency management and building the Spring Boot project
 ```bash
  mvn -version
  ```
- Navigate to the resources directory into the `application.properties` file and replace the values in brackets for the credentials of your database in the following variable
```bash
cd bancandes/src/main/resources/application.properties

spring.data.mongodb.uri=mongodb://<user>:<password>@<host>:<port>/<dbname>
```
- Create the following collections on your mongo database with this [script](docs/colecciones.txt)

## How to run

1. Open a terminal and navigate to the `main project folder`:
   ```bash
    cd bancandes
    ```
2. Build and run the application via Maven:
    ```bash
    mvn clean spring-boot:run
    ```
## Collaborators

- Alejandro Abril
- Gabriel Martinez


