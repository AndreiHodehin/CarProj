# CarProj

This web application is designed to develop practical skills in working with the web, databases and servlets.
This is a simple car rental site. Combined administration functionality and user interface.

# This Website is built for following purpose:

- this is a project for learning new technologies.
- were used : java, servlets, jsp, jstl, JDBC, MySQL

# Administrator has the following options
- add car
- check info about cars, its rent status 
- stop rent if its necessary
- delete car from database
- see info about users and delete it
# User has the following options.
- See available car 
- Rent car
- Manage rented car
# Techology used:
1.Front-end:
- jsp 
- jstl
- html 5

2.Back-and
- Java
- Servlets
- JDBC
- Maven

3.Database used:
- MySQL


======== Importing and Running The Project Through IntelligIdia ===========

Step 1: Open intelligIdea.

Step 2: Create new project from version control and past the repository URL as https://github.com/AndreiHodehin/CarProj.git

Step 3: Open MySql workbench > login and copy and paste the following command: 

    create database if not exists cars;
    
    user cars;
    
    create table car
    (
    id    int auto_increment
        primary key,
    name  varchar(20)      not null,
    price int              not null,
    rent  bit default b'0' null
    );
    
    create table user
    (
    id       int auto_increment
        primary key,
    name     varchar(20) not null,
    password varchar(20) not null,
    admin    bit         not null
    );
    
    create table user_car
    (
    user_id int not null,
    car_id  int not null,
    constraint user_car_ibfk_1
        foreign key (user_id) references user (id),
    constraint user_car_ibfk_2
        foreign key (car_id) references car (id)
    );

Step 4:  Go inside src/main/java/dao/AbstractDao  and update the value of database details as per your usage, like db.driver, db.host, db.username and db.password according to your installed mysql admin user credentials. 

Step 5: Connect Tomcat Server (Install, if not already installed). Run > Edit configuration > Add new configuration > Tomcat Local  and press "Fix" > choose "war exploded" artifact. 

Step 6 Use It.

