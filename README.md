# POC

A professor management app in which after registration, the user can create, read, update, and delete professors.

**Technologies Used**
1. Spring Security
2. Spring Web
3. MySQL
4. Spring Data JPA
5. Thymeleaf
6. Bootstrap
7. JUnit



**File Hierarchy**
* src/main/java
    * com.demo.poc.model: Map the entities with the tables in MySQL
      * Professor.java, Role.java, User.java
    * com.demo.poc.repository: Access User, Professor data from database
      * ProfessorRepository.java, UserRepository.java
    * com.demo.poc.service: CRUD operations on Professor, save and find User 
      * ProfessorService.java, ProfessorServiceImpl.java, UserService.java, UserServiceImpl.java
    * com.demo.poc.dto: Use DTO Design pattern to reduce the number of method calls
      * UserRegistrationDto.java
    * com.demo.poc.config: Configure user login and logout and encrypt the password
      * SecurityConfiguration.java
    * com.demo.poc.controller: Handle requests from HTML
      * MainController.java, ProfessorController.java, UserRegistrationController.java
      
      
      
* src/main/resources
    * login.html: the login page
    * registration.html: the registration page
    * index.html: the main page for the user to have CRUD operations on professors and view the list of professors
    * new_professor.html: the page helps the user add new professors to the database
    * update_professor.html: user can change the professors' first name, las tname, and email
    
* src/test/java
  * com.demo.poc: Add the test user case in the database and find the user by email
    * SpringbootPocprojectApplicationTests.java
    * UserRepoTest.java
    
