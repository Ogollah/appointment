# Appointment Management RESTAPI

# Introduction
This is a simple Appointment management meant for managing Patient appoints at a health facility.
The System is able to register new patient and add appointments for the patient. The relationship is one to many. One patient can have multiple appointments.

## Database Design
```
    +---------------------+       +---------------------+
    |      patients       |       |    appointments     |
    +---------------------+       +---------------------+
    | id (PK)             |       | id (PK)             |
    | first_name           |       | patient_id (FK)     |
    | surname             |       | appointment_date     |
    | other_name         |       | appointment_time     |
    | patient_number       |       +---------------------+
    | birth_date           |
    | id_number            |
    | mobile_number        |
    | email               |
    | alt_contact_erson    |
    | disability          |
    +---------------------+
```

## Getting Started

### Prerequisites
Before running Appointment Management RESTAPI, ensure you have

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)

### Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/Ogollah/appointment.git
   mvn clean install
   java -war target/appointment-1.0.0.war
   
   Access the APIS through http://localhost:8099
   ```
## API Endpoints
|Endpoint                            | Functionality                    |HTTP method 
|------------------------------------|----------------------------------|-------------
|/api/v1/patient                     |Create a patient                  |POST        
|/api/v1/appointment/{id}            |Adds a new appointment            |POST
