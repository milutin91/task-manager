# Task-manager
___
Simple application for managing tasks among employees.
___
### Technologies and tools used: 
* Java 
* Maven 
* Spring boot 3.0.4 
* Packaging jar 
* Java 17
* MySQL as the RDMBS (MySql Workbench 8.0 CE)
* Flyway migrations
* Hibernate as an ORM
* Thymeleaf for server-side templating
* Twitter Bootstrap for the UI
* IntelliJ
___
### Setup guide:
1. Open MySql Workbench, login with your username and password (Service: Mysql@localhost:3306), execute query: **CREATE DATABASE task_manager;**
2. Right click on created database, and click _Set as Default Schema_.
2. Download project from [Github](https://github.com/milutin91/task-manager)
3. Open project in IntelliJ
4. Navigate to application.properties (src/main/resources/application.properties)
5. Change username with your MySql username - _**spring.datasource.username=yourUsername**_
6. Change password with your MySql password - _**spring.datasource.password=yourPassword**_
7. Change username with your MySql username - _**spring.flyway.user=yourUsername**_
8. Change password with your MySql password - _**spring.flyway.password=yourPassword**_
9. Start application
10. Type **localhost:8080** in the address bar, and from there you can navigate through the app.
___
### Folder structure overview:
I used structure layout by layer:
```
src
  +-main
    +-java
    |   +-com.example.taskmanager
    |      +-controller
    |      |   +-EmployeeController
    |      |   +-MainController
    |      |   +-TaskController
    |      |   +-TeamControlle
    |      +-DTO
    |      |   +-EmployeeDTO
    |      |   +-EmployeeForTopFiveDTO
    |      |   +-TaskDTO
    |      |   +-TeamDTO
    |      +-mapper
    |      |   +-EmployeeMapper
    |      |   +-TaskMapper
    |      |   +-TeamMapper
    |      +-model
    |      |   +-Emplpoyee
    |      |   +-Task
    |      |   +-Team
    |      +-repository
    |      |   +-EmployeeRepository
    |      |   +-TaskRepository
    |      |   +-TeamRepository
    |      +-service
    |      |   +-EmployeeService
    |      |   +-TaskService
    |      |   +-TeamService
    |      TaskManagerApplication.java
    +-resources
```
___
### Additional functionalities :
* New entity Team is added
* Every employee can be part of the team
* List of teams can be shown
* List of active tasks can be shown
___
### TO DO:
* Exceptions
* Validations