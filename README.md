# Point of Sale (POS) System API

This is a Java EE-based API for a Point of Sale (POS) system, designed to handle various transactions and operations related to a point of sale environment.

## Endpoints Documentation

For API documentation, including available endpoints and methods, refer to [API Documentation](https://github.com/DasunMadawa/pos-system-java-ee/blob/master/APIDocumentation.md).

## Front End Web Page

For API documentation, including available endpoints and methods, refer to [Front End Code](https://github.com/DasunMadawa/POS-front-end).


## Usage

Once installed, you can perform the following operations:

- CRUD operations for customers, items, and orders.
- User authentication through login and registration.

## Logging

The POS Management System utilizes the Simple Logging Facade for Java (SLF4J) for proper logging. Logs provide insights into system behavior and help troubleshoot issues.

## Database Integration

The system is integrated with a MySQL database using Java Naming and Directory Interface (JNDI) for seamless data storage and retrieval.


## Technologies Used

- Java EE
- Apache Tomcat v9
- SLF4J (Simple Logging Facade for Java)
- JNDI (Java Naming and Directory Interface)

## Prerequisites

Make sure you have the following software installed on your system:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Tomcat v9](http://tomcat.apache.org/)
- [SLF4J](http://www.slf4j.org/)
- (Include any other dependencies or tools as needed)

## Project Structure

Explain the high-level structure of your project. For example:

```plaintext
pos-system-api/
|-- src/
|   |-- main/
|   |   |-- java/
|   |   |   |-- lk/
|   |   |   |   |-- ijse/
|   |   |   |   |   |-- pos_system/
|   |   |   |   |   |   |-- bo/
|   |   |   |   |   |   |-- controllers/
|   |   |   |   |   |   |-- dao/
|   |   |   |   |   |   |-- db/
|   |   |   |   |   |   |-- dto/
|   |   |   |   |   |   |-- entity/
|   |   |   |   |   |   |-- filter/
|   |   |   |   |   |   |-- util/
|   |   |   |-- resources/
|   |   |   |-- webapp/
|-- pom.xml
|-- ...
