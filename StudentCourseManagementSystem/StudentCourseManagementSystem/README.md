# Student Course Management System

A simple Spring Boot REST API project built in the same layered style as the Patient Management System.

## Technologies
- Java 21
- Spring Boot 4.1.1
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Postman
- Eclipse / STS

## Architecture
Controller -> Service -> Repository -> JPA/Hibernate -> MySQL

## Features
- User registration and login
- Student CRUD
- Course CRUD
- Assign student to a user
- Enroll a student in a course
- View all enrollments
- View enrollments by student
- View enrollments by course
- Drop/delete enrollment
- Duplicate enrollment protection
- Exception handling

## Database
Create the database before running:

```sql
CREATE DATABASE student_course_db;
```

Then update `src/main/resources/application.properties` if your MySQL username/password is different.

Default in this project:
- username: root
- password: root
- port: 9090

## Main APIs

### Authentication
POST `/api/auth/register`
POST `/api/auth/login`

### Students
POST `/api/students/user/{userId}`
GET `/api/students`
GET `/api/students/{id}`
GET `/api/students/user/{userId}`
PUT `/api/students/{id}`
DELETE `/api/students/{id}`

### Courses
POST `/api/courses`
GET `/api/courses`
GET `/api/courses/{id}`
PUT `/api/courses/{id}`
DELETE `/api/courses/{id}`

### Enrollments
POST `/api/enrollments/student/{studentId}/course/{courseId}`
GET `/api/enrollments`
GET `/api/enrollments/student/{studentId}`
GET `/api/enrollments/course/{courseId}`
DELETE `/api/enrollments/{id}`

## Example registration
```json
{
  "name": "Ravi Kumar Singh",
  "email": "ravi@gmail.com",
  "password": "123456"
}
```

## Example student
```json
{
  "name": "Rahul Sharma",
  "age": 21,
  "email": "rahul@gmail.com",
  "department": "Computer Science",
  "semester": "6"
}
```

## Example course
```json
{
  "courseName": "Java Programming",
  "courseCode": "JAVA101",
  "credits": 4,
  "instructor": "James Gosling"
}
```
