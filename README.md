# Purchase Management System

## Project Overview

The **Purchase Management System** is a Spring Boot application designed to manage the purchase of items within an organization. It handles the entire purchase process, including managing multiple items within a single purchase, generating unique packet and serial numbers based on item quantity and pack quantity, task queuing for multiple purchases, and notifying stakeholders upon task completion.

### Features

- **Item Management**: Manage item details including name, description, quantity, etc.
- **Purchase Management**: Handle purchases with multiple items, generate unique identifiers for packets and serials.
- **Notification System**: Notify stakeholders upon the completion of tasks.
- **API Support**: RESTful APIs for managing purchases, items, and related operations.

## Tools and Libraries Used

- **Java 17**: The core programming language used for the application.
- **Spring Boot 3.1.2**: Used to build the backend application with Spring MVC, Spring Data JPA, and Spring Security.
- **Hibernate 6.2.0**: ORM tool for database interactions.
- **MySQL 8.0**: Relational database management system.
- **Lombok 1.18.28**: To reduce boilerplate code in Java.
- **MapStruct 1.5.5**: For object mapping between DTOs and entities.
- **Maven**: Dependency management and build tool.
- **Postman : API testing tool.


## Project Setup

- **JDK 17** or later
- **Maven 3.8** or later
- **MySQL 8.0** or later

### EndPoints
Endpoints are available at postman collection