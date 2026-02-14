# Student Service - CRUD API

This project implements a **CRUD API** for managing student records using **Spring Boot**. The API supports basic operations such as creating, reading, updating, and deleting student data. The project is built with Java 17, Spring Boot 3.0+, and uses **MySQL** as the database with **JPA**/**Hibernate** for persistence.

## Project Overview

This Spring Boot application provides a simple RESTful API for managing student information. The main operations are:

- **Create** a student record
- **Read** student records (single or all)
- **Update** a student's details
- **Delete** a student's record
- **Search** students by name

## Features

- API built using **Spring Boot** (Java 17 and Spring Boot 3.0+).
- **MySQL** is used as the database for storing student records.
- Data is managed using **JPA** (Java Persistence API) and **Hibernate**.
- Each operation is mapped to a specific HTTP method and returns an appropriate **ResponseEntity**.
- Support for **request parameters**, **request bodies**, and **path variables**.
- **Validation** checks for student name, address, and marks in the `POST` and `PUT` requests.

## Technologies

- **Java 17**
- **Spring Boot 3.0+**
- **MySQL**
- **JPA / Hibernate**
- **Lombok** (for data classes)

## API Endpoints

### 1. Create a New Student
- **POST** `/students/create`
- **Request Body:**
  ```json
  {
    "studentName": "John Doe",
    "address": "123 Main St",
    "marks": "85"
  }
