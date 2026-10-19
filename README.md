# Employee API

A Spring Boot REST API that exposes employee records stored in MySQL.

The first part of a DevSecOps lab series, this application serves as the foundation for the CI/CD pipeline.

## Tech Stack

Java 25 · Spring Boot 4.1.1 · Spring Web · Spring Data JPA (Hibernate) · MySQL · ModelMapper · Lombok · Maven

## Features

| Endpoint | Description | Responses |
|---|---|---|
| `GET /employees/{id}` | Retrieves an employee by ID | `200` with JSON, `404` if the ID does not exist, `400` if the ID is not an integer |

Example: `GET http://localhost:9090/employees/1`

```json
{ "id": 1, "name": "Leila Ramzi", "age": 25 }
```

## Architecture

`controller` → `service` → `repository` → MySQL

The service converts the `Employee` entity into an `EmployeeResponse` DTO before returning it to the controller.

## Running the Project

1. **Create and populate the database:**

```sql
CREATE DATABASE employeedb;
USE employeedb;

CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    age INT
);

INSERT INTO employee(name, age)
VALUES
    ("Leila Ramzi", 25),
    ("Amine Ayad", 28),
    ("Lamyae Allali", 31),
    ("Mohammed Faizi", 36);
```

2. **Set the environment variables** (never store passwords in the repository):
   - `DB_USER` (default: `root`)
   - `DB_PASSWORD`

3. **Start the application:**

```bash
mvn spring-boot:run
```

The application runs on port **9090**.

## Smoke Test (Optional)

A demonstration runner (`SmokeTest`) exercises the repository and service at startup:

```bash
mvn spring-boot:run "-Dspring-boot.run.profiles=smoke"
```