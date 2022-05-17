# Spring_Boot_Java_Example

A quick rough example using Spring Boot and JPA, Hibernate among other technologies to create a functional API locally on port 8080 using PostgreSQL. All logic is
written in accordance to Spring framework, meaning Data Access, Service and API layers are all respected. Only the 4 main CRUD requests are implemented 
(GET, POST, PUT, DELETE). The DemoApplication class contains the main method to run.

Before running, first a username and password must be given in the applications.properties file 
to provide authentication (spring.datasource.username and spring.datasource.password).

Database is a simple table of students with ID, Name, Email, and DOB (age is a transient property).
Student is the main object of the project.
