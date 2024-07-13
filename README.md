# Clinic Management System and Clinic Appointment System

## Presentation Link
- 

## Overview

This project involves two main applications: the Clinic Management System and the Clinic Appointment System. Each application serves different purposes and functionalities within the clinic's operational framework.


## Applications Involved

1. **Clinic Management System**
2. **Clinic Appointment System**


## Brief Explanation of each app

### 1. Clinic Management System

The Clinic Management System is designed to streamline the management of patients and appointments within the clinic. It includes two main modules:

- **Manage Patients**: This module allows the clinic staff to add, update, and delete patient information.
- **Manage Appointments**: This module facilitates scheduling, updating, and canceling appointments between patients and doctors.

### 2. Clinic Appointment System

The Clinic Appointment System is a user-facing application that allows patients to check their appointment details. It includes a single module:

- **Check Appointment Details**: Patients can enter their IC number to retrieve details about their scheduled appointments.


## Architecture/Layer Diagram

### Clinic Management System

Image Here 
Architecture_Layer_Diagram.jpg


### Clinic Appointment System

Image Here 
Architecture_Layer_Diagram.jpg


## Middleware RESTful Endpoints

### Clinic Management System

- Manage Patients

* GET http://localhost:8080/api/patients - Retrieve all patients
* GET http://localhost:8080/api/patients/{id} - Retrieve patients by id
* POST http://localhost:8080/api/patients - Add a new patient
* PUT http://localhost:8080/api/patients/{id} - Update a patient's details
* DELETE http://localhost:8080/api/patients/{id} - Delete a patient

- Manage Appointments

* GET http://localhost:8080/api/appointments - Retrieve all appointments
* GET http://localhost:8080/api/appointments/{id} - Retrieve appointments by id
* POST http://localhost:8080/api/appointments - Schedule a new appointment
* PUT http://localhost:8080/api/appointments/{id} - Update an appointment
* DELETE http://localhost:8080/api/appointments/{id} - Cancel an appointment

### Clinic Appointment System

- Check Appointment
* GET http://localhost:8080/api/appointments/{icNo} - Retrieve appointment details by IC number

## Web Endpoints

### Clinic Management System

- Manage Patients

* http://localhost:8080/patients - View all patients
* http://localhost:8080/patients/new - Show the form to add a new patient
* http://localhost:8080/patients/edit/{id} - Show the form to edit an existing patient

- Manage Appointments

* http://localhost:8080/appointments - View all appointments
* http://localhost:8080/appointments/new - Show the form to schedule a new appointment
* http://localhost:8080/appointments/edit/{id} - Show the form to edit an existing appointment

### Clinic Appointment System

- Check Appointment Details

* http://localhost:8080/check-appointment - Show the check appointment form


## Functions/Features in the Middleware

### Clinic Management System

- Manage Patients
* Adding new patients
* Updating existing patient information
* Deleting patients from the system

- Manage Appointments
* Scheduling new appointments
* Updating appointment details
* Canceling appointments

### Clinic Appointment System

- Check Appointment Details
* Retrieving appointment information based on the patient's IC number


## Database and Tables Involved (clinic.sql)

Database name - clinic

Tables : 

- Patients Table
id (Primary Key)
name
ic_no (IC Number)
age
gender
phone
email
created_at

- Appointment Table
id (Primary Key)
patient_name
patient_phone
ic_no
doctor_name
appointment_date
appointment_time
purpose
status
created_at


## Prerequisites

Before running the applications, ensure that you have the following installed:

- **Java JDK 17**: The applications are built using Spring Boot and require JDK 17.
- **Maven**: For building and running the Spring Boot applications.
- **Postman** (optional): For testing the RESTful APIs.
- **XAMPP** or another local server software: To set up and manage the MySQL database.
- **Eclipse IDE with Spring Tools 4** (recommended for easier setup and management of Spring Boot applications).

## Running the Applications

### 1. Set Up the Database

#### Using XAMPP

1. **Start XAMPP**: Open the XAMPP Control Panel and start the Apache and MySQL services.

2. **Access phpMyAdmin**: Open your web browser and navigate to `http://localhost/phpmyadmin`.

3. **Create the Database**:
   - Click on the "Databases" tab.
   - Enter `clinic` as the database name.
   - Click "Create".

4. **Import the Database Schema**:
   - In phpMyAdmin, select the `clinic` database from the list on the left.
   - Click on the "Import" tab.
   - Click "Choose File" and select the `clinic.sql` file provided.
   - Ensure the format is set to `SQL`.
   - Click "Go" to import the schema and populate the database with tables and initial data.

### Modify Database Credentials

1. **Open `application.properties` for each apps**:
   - Navigate to the `src/main/resources` folder of each project.
   - Open the `application.properties` file in a text editor or IDE.

2. **Update Database Connection Details**:
   - Modify the properties to match your database credentials.



## Easier Setup Using Eclipse IDE with Spring Tools 4 (Suggested Ways to Run)

### Install Spring Tools 4:
Open Eclipse IDE.
Go to Help > Eclipse Marketplace.
Search for "Spring Tools 4" and click "Go".
Click "Install" next to Spring Tools 4 (aka Spring IDE).
Follow the installation steps and restart Eclipse when prompted.

### Import the Project (Clinic Management System & Clinic Appointment System ):
Open Eclipse IDE.
Go to File > Import.
Select Existing Maven Projects and click Next.
Click Browse to select the directory containing the project.
Click Finish to import the project.

### Run the Application:
Right-click on the project you wish to run in the Project Explorer.
Select Run As > Spring Boot App.

The application will start and be accessible on the specified port 8080 (default), Refer to the endpoint given above (## Web Endpoints) to access the url.


## Setup Using Eclipse IDE without Spring Tools 4 (Not Suggested Ways to Run)

### 2. Clinic Management System

#### a. Navigate to the Project Directory

Open a terminal or command prompt and navigate to the directory containing the `Clinic Management System` application.
cd /path/to/clinic-management-system

#### b. Build the Application
mvn clean install

#### C. Run the Application
mvn spring-boot:run


### 3. Clinic Appointment System

#### a. Navigate to the Project Directory

Open a terminal or command prompt and navigate to the directory containing the `Clinic Appointment System` application.
cd /path/to/clinic-appointment-system

#### b. Build the Application
mvn clean install

#### C. Run the Application
mvn spring-boot:run


## Troubleshooting
Application Fails to Start: Ensure that JDK 17 is correctly installed and configured also in the project build path change to alternate JRE and select JDK 17. Check the application logs for detailed error messages.
API Endpoints Not Found: Verify that the application is running on the correct port and that the URL paths match those specified in the README.md.


This updated `README.md` provides an alternative and easier method for running the applications using Spring Tools 4 in Eclipse IDE, in addition to the Maven command-line instructions.
