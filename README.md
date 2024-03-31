
# Assesment Exercise

This repository contains a Spring Boot Application for the Assessment Exercise by a confidential company.

## Deliverables
Following are the deliverable for Assesment Exercise <br>
1.  Spring Boot Application
2.  Application UML Diagram ***(available at artifacts/exercise.drawio)***
3.  Application Source Code Static Analysis report  ***(available at artifacts/pmd-lint-analysis)***
4.  Application Test Coverage report ***(available at artifacts/jacoco-test-coverage)***
5.  Sample Input data to run the application ***(available at artifacts/*.json files)***
6.  Sonar Qube Summay for code Quality ***(available at artifacts/sonaeqube-summary)***

## Application Dependencies
1. Java 17 (Can be compatiable with java 8 then need to change in pom.xml)
2. Maven Build Tool
3. spring-boot-starter
4. spring-boot-starter-test
5. lombok
5. jackson-databind

## Code Analysis & Coverage
1. Junit is used for Application Unit testing
2. For Test Coverage **[Jacoco](https://www.jacoco.org/)** Plugin is used
3. For Static Code Analysis **[PMD](https://pmd.github.io/)** Plugin is used
4. For Code quality  **[Sonar Qube](https://www.sonarsource.com/)** is used

## Following are the Assumption while building application
1.  The application is designed as a pluggable component that can be integrated into any application.
2.  Discount will not be applied for bills containing all grocery items

## Running test case and executing application with sample Input
1. Clone the appliction repository
2. To execute all test cases, run the following command from the root directory of the application:
- `mvn clean test`
3. To build the application as a runnable JAR, run the following command from the root directory of the application:
- `mvn clean install`
4. To run the application with sample input, execute the following command from the root directory of the application and observe the output:
-  `java -jar .\target\exercise-0.0.1-SNAPSHOT.jar .\artifacts\employee.json`
5. Replace the JSON file for other user types, etc
