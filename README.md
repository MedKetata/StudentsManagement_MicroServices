# StudentsManagement_MicroServices
Full-stack microservices application for managing students and addresses using Spring Boot, Spring Cloud (Eureka, OpenFeign), API Gateway, and Angular

# 🎓 Student Management Microservices System

A full-stack microservices application for managing students and addresses using Spring Boot, Spring Cloud (Eureka, OpenFeign), API Gateway, and Angular.

---

## 📌 Overview

This project demonstrates a distributed microservices architecture where:

- Students and Addresses are managed in separate microservices
- Services are registered using Eureka
- API Gateway routes external requests
- OpenFeign enables inter-service communication
- Angular provides a modern UI with pagination and dialogs

---

## 🏗️ System Architecture Diagram

![System Architecture](screenshots/Architecture.png)

---

## 🛠️ Technologies Used

### Backend
- Java 17
- Spring Boot
- Spring Cloud
- Eureka Server
- OpenFeign
- API Gateway
- MySQL
- Maven

### Frontend
- Angular
- Angular Material
- Bootstrap

---

## 🚀 Features

### 👨‍🎓 Student Service
- Create Student
- Update Student
- Delete Student
- Get All Students (with address info)
- Pagination
- Filtering

### 🏠 Address Service
- Create Address
- Update Address
- Delete Address
- Get Address by ID
- Pagination
- Filtering

### 🌐 System
- Service Discovery with Eureka
- Inter-service communication via Feign
- Confirmation dialogs before deletion
- Clean Angular UI

---

## ⚙️ How to Run

Start services in this order:

1. Eureka Server
2. API Gateway
3. Address Service
4. Student Service
5. Angular Frontend

Frontend runs on:

http://localhost:4200



## 📸 Screenshots

### 🏠 Students Page
![Students Page](screenshots/students_page.png)

### 📄 Students With Pagination
![Students Pagination](screenshots/students_page_with_pagination.png)

### ➕ Add Student (Mathieu Example)
![Add Student](screenshots/add_student_mathieu.png)

### ✅ Student Added
![Student Added](screenshots/added_student_mathieu.png)

### ➕ Student Address Added
![Student Address Added](screenshots/student_mathieu_address_added.png)

### 🗑 Delete Student Dialog
![Delete Student Dialog](screenshots/delete_student_dialog.png)

### 🗑 Student Deleted
![Student Deleted](screenshots/student_deleted.png)

---

### 🏠 Addresses Page
![Addresses Page](screenshots/addresses_page.png)

### 📄 Addresses With Pagination
![Addresses Pagination](screenshots/addresses_with_pagination.png)

### ➕ Add New Address
![Add Address](screenshots/add_new_address_dialog.png)

### ✅ Address Added Successfully
![Address Added](screenshots/address_added_successfully.png)

### ✏ Update Address Dialog
![Update Address Dialog](screenshots/update_address_dialog.png)

### ✅ Address Updated
![Address Updated](screenshots/address_updated.png)

### 🗑 Delete Address Dialog
![Delete Address Dialog](screenshots/delete_address_dialog.png)

### 🗑 Address Deleted
![Address Deleted](screenshots/address_deleted.png)

---

### 🧭 Eureka Dashboard
![Eureka Dashboard](screenshots/eureka_dashboard.png)

### 🔎 Filter Students
![Filter Students](screenshots/filter_students.png)

### 🔎 Filter Addresses
![Filter Addresses](screenshots/filter_addresses.png)