# Inventory System (v1.0) - Backend
Backend part of Inventory System (v1.0) in Java (Spring Boot)<br>
Frontend part: [Here](https://github.com/tsokying/Inventory-frontend)

### Introduction
1) An Inventory Management System with CRUD functions, mainly for tables of "Stock", "Product" and "Location" (Shop).
2) Request can be made, to transfer stock from Location A to Location B. The record will be stored in "Packages".
3) The tranfering packages could be uploaded by User.

### Database structure
* Stock:      id, product_id (FK), location_id (FK), qty
* Product:    id, productName, productCode, status
* Location:   id, locationName, locationCode
* Package:    id, product_id (FK), qty, weight, dimension, status:{ from, to, by }
* User:       id, employeeCode, firstName, lastName

### How to run

with [maven installed](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)
```sh
$ cd Inventory-backend
$ mvn spring-boot: run
```
the application with run on port 8080 by default

### Development daily:
* The app in NOT completed

learn / think / try / develop

1) Day one: 
* Try to design the database structure. [(current design)](https://docs.google.com/spreadsheets/d/1zuuDitgCd5jsAlSqjQahva1uXUs8r5ohqWGWttBjfJY/edit?usp=sharing)
* Learn and study OneToMany, ManyToOne, ManyToMany relations in JPA. (and fail to use them)
* Student more about database designs (1NF, 2NF and 3NF).
* Setting up the Entities.
* Learn about Project Lombok.

2) Day two:
* After failing to use OneToMany, ManyToOne, ManyToMany relations, redesign the database structure.
* Adding "Stock" and "Package"; and cut down the databse structure to five tables. (Highlighed in Orange)
* Setting up Repositories, Services and Controllers.
* Test with Postman.
* implement csv files reading (backend).

3) Day Three:
* Design the frontend with "bootstrap-table" 
* Failing to convert "bootstrap-table" into React Component.
* Redsign the table with "react-bootstrap-table2".
* Setting up Redux's store, actions and reducers.

4) Day Four:
* Implement csv files uploading (frontend).
* Button send APIs to CRUD datas.
