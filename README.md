# Placement Management System

A Spring Boot REST API for managing student placement records, built with Spring Data JPA and PostgreSQL.

## 📌 Project Overview

The Placement Management System is a backend application that lets you create, view, update, and delete student placement records through a clean set of RESTful APIs, backed by a PostgreSQL database.

Built as part of the TNS India Foundation / Capgemini Java Full Stack training program (GIT, PostgreSQL, Core Java 8, Spring 5.0/Spring Boot).

## 🚀 Features

- Full CRUD operations on placement records
- Clean DTO layer decoupling API contracts from JPA entities
- Bean Validation on incoming requests (required fields, positive year check)
- Centralized exception handling with meaningful error responses (404 for missing records, 400 for invalid input)
- Auto-generated primary keys
- PostgreSQL database integration via Spring Data JPA / Hibernate

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Java | Programming Language |
| Spring Boot 3.4.2 | Backend Framework |
| Spring Data JPA | Data Access |
| Hibernate | ORM |
| PostgreSQL | Database |
| Bean Validation (Jakarta Validation) | Input validation |
| Maven | Build Tool |
| Git & GitHub | Version Control |

## 🏗️ System Architecture

```text
Client
   │
   ▼
REST Controller (DTOs)
   │
   ▼
Service Layer (DTO ↔ Entity mapping, business logic)
   │
   ▼
Repository Layer
   │
   ▼
PostgreSQL Database
```

## 📚 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/placements` | Create a new placement record |
| GET | `/placements` | Get all placement records |
| PUT | `/placements/{id}` | Update a placement record by ID |
| DELETE | `/placements/{id}` | Delete a placement record by ID |

### Sample request body (POST / PUT)

```json
{
  "name": "Suresh",
  "date": "2026-08-16",
  "qualification": "MCA",
  "year": 2025
}
```

### Validation rules

| Field | Rule |
|---|---|
| `name` | Required, cannot be blank |
| `date` | Required |
| `qualification` | Required, cannot be blank |
| `year` | Must be a positive number |

Invalid requests return a `400 Bad Request` with a field-level error message. Requesting an unknown `id` on update/delete returns a `404 Not Found`.

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Maven
- PostgreSQL

### Environment Variables

| Variable | Description |
|---|---|
| `DB_URL` | PostgreSQL JDBC URL (defaults to `jdbc:postgresql://localhost:5432/postgres`) |
| `DB_USERNAME` | PostgreSQL username (defaults to `postgres`) |
| `DB_PASSWORD` | PostgreSQL password |

### Run locally

```bash
git clone https://github.com/suresh-1219/placement-management-system.git
cd Placement_Management

set DB_PASSWORD=your_db_password

mvn spring-boot:run
```

The application runs on `http://localhost:8080`.

## 📄 License

This project was built as a personal portfolio project.
