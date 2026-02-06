# CRM Backend Application

A backend CRM application built using Spring Boot to manage employees, departments, projects, and users with role-based access control.

---

## 🛠 Tech Stack
- Java
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- MySQL
- Maven

---

## ✨ Features
- User authentication using Spring Security
- Role-based authorization
- Employee management (CRUD operations)
- Department and project management
- Secure RESTful APIs
- Layered architecture (Controller, Service, Repository)
- DTO-based request and response handling
- Global exception handling

---

## 🧱 Project Structure
- `controller` – REST controllers for handling API requests  
- `service` – Business logic implementation  
- `repository` – JPA repositories for database access  
- `entity` – JPA entity classes  
- `dto` – Data Transfer Objects  
- `config` – Spring Security configuration  
- `exception` – Custom exceptions and handlers  
- `enums` – Enums for roles and other constants  

---

## 🔐 Security
- Authentication handled using **Spring Security**
- Role-based access control implemented
- Uses **session-based authentication** (form login / basic authentication)

---

## ▶️ Run Locally

1. Clone the repository
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
