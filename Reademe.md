# Spring Boot OTP Email Verification System

## 📌 Project Overview

This project implements a **complete email-based OTP verification and registration system** using:

- Spring Boot
- MySQL Database
- Gmail SMTP
- Thymeleaf Frontend

It is a **real-world authentication feature** commonly used in production applications.

---

## 🚀 Features

✔ User Registration  
✔ Email OTP Verification  
✔ OTP Stored in Database  
✔ OTP Expiry (5 minutes)  
✔ Resend OTP Functionality  
✔ Account Activation after Verification  
✔ Thymeleaf Frontend Pages  

---

## 🔁 Application Flow

# Spring Boot Transaction Propagation (MySQL)

## 📌 Project Overview

This project demonstrates **Spring Boot Transaction Management** using:

- `@Transactional`
- Transaction Propagation
- `REQUIRED` and `REQUIRES_NEW`
- MySQL Database
- Real-world banking example

The application simulates a **money transfer system with audit logging**, where audit logs are saved even if the main transaction fails.

---

## 🚀 Features

✔ MySQL database integration  
✔ Transaction management using Spring  
✔ REQUIRED propagation (default)  
✔ REQUIRES_NEW propagation  
✔ Automatic rollback on failure  
✔ Separate audit transaction  
✔ Real enterprise-level example  

---

## 🧠 Transaction Flow

# File Upload & Download – Spring Boot

## Features
- Upload file
- Download file
- Save file info in database
- Store file on server

## Technologies
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- MultipartFile

## APIs
POST /file/upload  
GET /file/download/{id}

## Learning
- MultipartFile
- File handling
- Resource
- ResponseEntity

# Image Upload & Preview API – Spring Boot

## Features
- Upload image
- Preview image in browser
- Store image on server
- Save image details in DB

## APIs
POST /image/upload
GET /image/view/{id}

## Learning
- MultipartFile
- MediaType
- Resource
- Image preview

🔗 APIs
🔼 Upload Image
POST /image/upload


Form-data:

key = image
type = File

👁️ Image Preview (Browser)
GET /image/view/{id}


Example:

http://localhost:8080/image/view/1



# Invoice PDF Generation – Spring Boot

## Features
- Generate invoice PDF
- Fetch data from database
- Logo image in header
- Footer message
- Auto total calculation

## Tech Stack
- Spring Boot
- OpenPDF
- JPA
- MySQL

## API
GET /invoice/pdf/{id}

## Learning
- PDF table
- Image in PDF
- Header footer
- Database integration
