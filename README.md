# BancandesNoSQL

## Description

This Java application project was developed as part of the **ISIS2034 Sistemas Transaccionales (Databases)** course at _Universidad de Los Andes_.  It allows users to create, browse, and search clients, managers, accounts, branches, service points, tellers, and transactions through a command-line interface. Designed for efficient data handling and modular interaction.

## Project Documentation

- [UML Diagram](docs/UML_final.png)

## Tech Stack

- **Backend:** Java with Spring Boot
- **Data Persistence:** Implemented using MongoDB, a NoSQL document-oriented database.

## Repository Structure

The project is organized into one main folder:
- `BancandesNoSQL/`
  - `bancandes`

## Prerequisites

To run this project locally, ensure the following tools are installed:

-  **Java Development Kit (JDK)** — version 11 or higher

  You can verify installation with:
  ```bash
  java -version
  ```
- **Maven** — for dependency management and building the Spring Boot project
 ```bash
  mvn -version
  ```
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


