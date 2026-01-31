Identity & Access Management (IAM) Service

A production-ready Identity & Access Management (IAM) API built with Spring Boot that provides client-based authentication, user signup/login, and JWT token validation. Designed as a central auth service consumable by third-party applications.

---

Built a centralized IAM system similar to Auth0-style internal auth

Supports client registration, user authentication, and JWT validation

Implements stateless authentication using Spring Security + JWT

---

⚙️ Core Capabilities

Client (application) onboarding with clientId + secretKey

Secure user signup & login per client

JWT token generation on successful authentication

Token validation endpoint for downstream services

Input validation using Jakarta Validation

---

 ⚙️ System Design Overview

Client App
   │  clientId + secretKey
   ▼
IAM Service (Spring Boot)
   ├── Client Registration
   ├── User Signup / Login
   ├── JWT Issuance
   └── Token Validation API


---

📁 Project Structure

controllers/     → REST APIs (Auth, Client Registration)
DTO/             → Request & Response models
service/         → Business logic
repositories/    → Database access (JPA)
security/        → JWT & Spring Security config


---

🔐 Authentication Flow

1. Client registers and receives credentials


2. Client uses credentials to register/login users


3. IAM service authenticates user


4. JWT token issued


5. Token validated by downstream services via API

---

Client Registration

POST /client/register

{ "appName": "MyApp", "secret": "mySecretKey" }

Response

{ "clientId": "generated-id", "secretKey": "generated-key" }


---

User Authentication

POST /auth/login

{ "clientId": "id", "secretKey": "key", "username": "john", "password": "password123" }

Response

{ "token": "jwt-token" }


---

Token Validation

POST /auth/validateToken

{ "token": "jwt-token" }

Response

{ "valid": true }


---

🔒 Security Stack

Spring Security AuthenticationManager

JWT-based stateless authentication

Client-level access validation



---

🛠 Tech Stack

Java

Spring Boot

Spring Security

JWT

Hibernate / JPA

Jakarta Validation

---

🧩 Future Enhancements

Refresh tokens

OAuth2 compatibility

Rate limiting & audit logging

Improved error handling

---

👤 Author

Utkarsh Ingle
Java Backend Developer