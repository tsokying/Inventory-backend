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
