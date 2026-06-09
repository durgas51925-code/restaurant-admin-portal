# Restaurant Administration Portal

A Spring Boot REST API for managing restaurant operations including employees, menu items, orders, authentication, and role-based access control.

## ✨ Features

- Employee Management
- Menu Management
- Order Management
- JWT Authentication
- Role-Based Authorization
- Input Validation
- Global Exception Handling
- Swagger API Documentation
- MySQL Database Integration
- Spring Data JPA & Hibernate

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger/OpenAPI
- Git & GitHub

## 👥 Roles

 ADMIN

- Manage Employees
- Manage Menu
- Manage Orders

 MANAGER

- Manage Menu
- Manage Orders

 STAFF

- Manage Orders

## 🔐 Authentication

JWT-based authentication is implemented.

1. Login Endpoint

POST /auth/login


2. Request Body:

json
{
  "username": "admin",
  "password": "admin123"
}


3. Response:

json
{
  "token": "your-jwt-token"
}


4. Use the token in:

Authorization: Bearer <token>


## 📦 Main Modules

 Employee Module

- Add Employee
- Get Employee By ID
- Get All Employees
- Delete Employee

 Menu Module

- Add Menu Item
- Update Menu Item
- Get Menu Items
- Delete Menu Item

 Order Module

- Create Order
- Get Order By ID
- Get All Orders
- Update Order Status

## ✅ Validation

Implemented using:

- @NotBlank
- @NotNull
- @Positive
- @Valid

## 📖 API Documentation

Global exception handling implemented using:

- @RestControllerAdvice
- @ExceptionHandler

 ##API Documentation

Swagger UI:

http://localhost:8080/swagger-ui/index.html


## 🗄️ Database

MySQL is used as the primary database.

Example configuration:

properties->
-spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_db   

-spring.datasource.username=root

-spring.datasource.password=your_password

-spring.jpa.hibernate.ddl-auto=update


## 📁 Project Structure


-controller
-service
-repository
-entity
-dto
-exception
-jwt
-config


## 🚀 How To Run

1. Clone Repository

2. Configure MySQL

3. Run Application

4. Access Swagger UI


## 👨‍💻 Author

🎓Durga prasad

Java Backend Developer.
