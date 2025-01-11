# Spring Boot Application Setup Guide

This guide will help you set up and run the Spring Boot application with the following configurations:

- **Schema name:** `siamsavvy`
- **Application Port:** `8095`
- **Swagger UI Access:** [http://localhost:8095/swagger-ui/index.html](http://localhost:8095/swagger-ui/index.html)

## Prerequisites

Before you begin, ensure you have the following installed on your local machine:

- **Java 17** or later
- **Maven** (for building the project)
- **Spring Boot** (if not included in the project)

## Steps to Set Up the Application

### 1. Clone the Repository

Clone the project repository to your local machine:

```bash
git clone <repository-url>
cd <project-directory>
```

### 2. Set Up Database Schema

Ensure your MySQL/MariaDB database server is running. Create the `siamsavvy` schema by running the following SQL command:

```sql
CREATE SCHEMA siamsavvy;
```

You can use a tool like **phpMyAdmin**, **DBeaver**, or any MySQL client to run this query.

### 3. Configure Application Properties

In the project folder, navigate to `src/main/resources/application.properties`

Update the database connection details with your MySQL/MariaDB database credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres?currentSchema=siamsavvy
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```

### 4. Run the Application

Run the Spring Boot application using Maven:

```bash
mvn spring-boot:run
```

Alternatively, you can build and run the application as a JAR file:

```bash
mvn clean package
java -jar target/<your-app-name>.jar
```

By default, the application will run on port `8095`.

### 5. Access Swagger UI

Once the application is running, open your web browser and navigate to:

[http://localhost:8095/swagger-ui/index.html](http://localhost:8095/swagger-ui/index.html)

This will provide access to the Swagger UI, where you can interact with the available API endpoints.

## Troubleshooting

- Ensure the MySQL/MariaDB server is running and accessible.
- Make sure port `8095` is not being used by another application.

