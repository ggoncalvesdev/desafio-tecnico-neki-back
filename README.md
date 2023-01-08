> # Agile Back-End
<p align="center">
  <img width= 200 src= https://user-images.githubusercontent.com/92227976/211206151-d3999d11-9a7a-4a3d-8ef6-1b9b9129793d.png>
</p>
<p>

Full Stack technical challenge for the company <a href="https://neki-it.com.br/" target="_blank" rel="noopener noreferrer">Neki-it.</a></p>

This codebase was created to demonstrate a full-stack application based on Spring boot,
react native(
Expo)

including CRUD operations, authentication,
sequence,
password check,
encrypted password
 and much more.
    
   If you are interested in knowing how the complete application works, we have a Front-end ready for that, access the <a href="https://github.com/ggoncalvesdev/desafio-tecnico-neki-front" target="_blank" rel="noopener noreferrer"> desafio-tecnico-neki-front</a> repository
 
 <p align="left">
   <img src="https://img.shields.io/badge/spring--boot-2.7.6-green" alt="Spring-Boot" />
   <a href="LICENSE">
    <img src="https://img.shields.io/badge/license-MIT-brightgreen.svg" alt="MIT License" />
   </a>
   <a href="https://www.npmjs.com/package/npm/v/8.5.0">
    <img src="https://img.shields.io/badge/npm-8.5.5-blue" alt="NPM">
   </a>
   <a>
    <img src="https://img.shields.io/badge/java-11-red" alt="Java 11">
  </a>
 </p>
 
# Tools
  
* [MAVEN](https://maven.apache.org/) as a dependency manager.
* [Flyway](https://flywaydb.org/) for database migrations.
* [ModelMapper](http://modelmapper.org/) to map objects and transform one model into another.
* [SpringFox](https://springfox.github.io/springfox) to scan the code and generate a Json definition file.
* [Swagger UI](http://localhost:8080/swagger-ui/index.html) to generate HTML documentation.
* [Lombok](https://projectlombok.org/) to increase productivity.
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa) facilitate the creation of the repository.
* [Postman](https://www.postman.com/) to facilitate HTTP requests.
    * Api developed with Postman to make HTTP requests.( easy app for the postman to use for http requests if you have it on your machine, not      preventing you from using a tool of your own )
    
## Files

-   `NekiApplication.java` responsible for starting the application.
-   `application.properties` responsible for storing development settings.
-   `V001__teste_residencia.sql` responsible for initializing entities in the database.
-   `pom.xml` responsible for manage dependencies and centralize project documentation.

And the code is organized as this:

1. `api` It is the layer responsible for communicating with the client.
2. `core` and the layer responsible for containing the application settings.
3. `domain` It is the layer responsible for containing the business rules.

# Security

Integration with Spring Security and add other filter for jwt token process.

The secret key is stored in `application.properties`.

# Database

Uses the Postgresql database. The API can be easily changed in `application.properties` for any other database.

# Getting started

You'll need Java 11 installed.

mvn spring-boot:run ou mvnw spring-boot:run(if you don't have MAVEN installed on your machine)

To test that it works, open a browser tab at http://localhost:8080/tags .  
Alternatively, you can run

    curl http://localhost:8080/tags

# Help

Please fork and PR to improve the project.

