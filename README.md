# Code Sharing Platform
> A web service for sharing code snippets with members of programming team

## General info
This web application provides a platform for storing and sharing pieces of code. It comes with two types of interfaces: API and web interface. The API interface returns data in JSON format, while the web interface uses HTML, CSS and JavaScript. The functionality covers posting new code, displaying it with its creation time as well as returning 10 most recently uploaded code snippets sorted from the newest to the oldest. There is also a possibility to include two restrictions: a limit on the number of views and a limit on the viewing time. When at least one of these limits is reached, the code snippet is automatically deleted. All the data is stored in H2 database using Spring Data JPA.

## Technologies
* Java SE 11
* Spring Boot 2.4.10
  - Spring Boot Starter
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Actuator
  - Spring Boot Starter Freemarker
* H2 Database Engine 1.4.200
* HTML
* CSS
* JavaScript
* Maven 3.6.3
