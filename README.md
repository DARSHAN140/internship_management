📁 Internship Management System
📌 Description

Internship Management System est une application web Java conçue pour gérer les stages académiques.
Elle permet de gérer :

Les étudiants

Les entreprises

Les stages

Les affectations de stages

Le projet suit une architecture REST avec séparation claire entre :

Entités

DAO (accès aux données)

Services (logique métier)

Resources (API REST)

Il utilise JPA, CDI, Servlet / REST, et une base de données via persistence.xml.

🛠️ Technologies utilisées

Java (Jakarta EE / JEE)

JPA / Hibernate

REST API

Maven

HTML

Base de données (via persistence.xml)

Architecture MVC / Layered

📂 Arborescence du projet
internship_management/
├── src/
│   ├── main/
│   │   ├── java/com/school/internship/internship_management/
│   │   │   ├── dao/
│   │   │   │   ├── CompanyDAO.java
│   │   │   │   ├── GenericDAO.java
│   │   │   │   ├── InternshipDAO.java
│   │   │   │   └── StudentDAO.java
│   │   │   ├── entity/
│   │   │   │   ├── Company.java
│   │   │   │   ├── Internship.java
│   │   │   │   └── Student.java
│   │   │   ├── exception/
│   │   │   ├── resource/
│   │   │   │   ├── CompanyResource.java
│   │   │   │   ├── InternshipResource.java
│   │   │   │   └── StudentResource.java
│   │   │   └── service/
│   │   │       ├── CompanyService.java
│   │   │       ├── InternshipService.java
│   │   │       └── StudentService.java
│   │   ├── resources/META-INF/
│   │   │   └── persistence.xml
│   │   └── webapp/
│   │       ├── WEB-INF/beans.xml
│   │       └── index.html
│   └── test/
├── pom.xml
└── internship-management.war
