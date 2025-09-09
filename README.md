**🏥 Healthcare Application System (HMS)** – Backend

**Introduction:**

Healthcare Application System is a secure, scalable platform engineered to simplify and automate all core hospital operations—including patient records, medical staff scheduling, appointments, billing, and robust, multi-role authentication. Built with the latest Java technologies, it is designed for extensibility and enterprise-grade reliability.

**Project Summary:**

A robust, secure RESTful application for end-to-end healthcare application management, crafted with:

**Java 17, Spring Boot**

__MySQL__ — primary database (H2 for development/testing)

__Spring Security__ (JWT-based authentication & authorization)

__Spring Data JPA/Hibernate__ (for ORM)

__Swagger UI__ (for interactive API documentation/testing)

__Maven__ (builds & dependency management)

__Docker__ (containerized deployment & CI/CD ready)

**Functional Coverage:**
**Admins:**

__Manage all hospital entities:__ 

Doctors, Patients, Appointments.
Assign roles and permissions.
Generate operational and billing reports.

__Doctors:__

View/manage their schedule and assigned patients.
Maintain and update patient records.
Create prescriptions and complete reporting.

__Patients:__

Book, reschedule, or cancel appointments.
View personal treatment/prescription history.
Download invoices, bills, and medical reports.

__Security:__

Full role-based authentication and authorization with Spring Security and JWT tokens.
Password encryption and secure REST endpoints.
Advanced access control for data privacy and patient/doctor/admin segregation.

__Persistence:__

Spring Data JPA (Hibernate) for robust ORM and data integrity.

__All major entities:__

Doctor, Patient, Appointment, Bill, User, Role, Prescription.
Proper modeling of entity relationships (OneToMany, ManyToOne) to reflect real healthcare workflows.

__API Testing & Documentation:__

Swagger UI integrated for interactive API testing, exploration, and live documentation.

__DevOps & Deployment:__

Maven: Handles full dependency management and streamlined builds.

__Dockerfile:__

 Enables containerized deployment for consistency across environments.
Suitable for modern CI/CD pipelines and cloud-native hosting.

