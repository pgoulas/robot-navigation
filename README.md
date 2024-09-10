# The room cleaner App

Below are the instructions for setting up, deploying, and testing the application

## Prerequisites

- Java 21
- Maven 3.6+
- Docker

### 1. Installation and Setup

Clone the repository:
```bash
git clone https://github.com/pgoulas/robot-navigation.git
cd room-cleaner
```

### 2. **Running the Application**
This section describes how to start the Spring Boot application.

Run the following script that will build the code and will create a docker container

```bash
build_and_deploy.sh
```
Once the app is up and running, you can access it via Swagger api(http://localhost:8080/swagger-ui/index.html)
or directly using a tool for API Calls like POSTMAN

### 3. API Endpoint
The API below is created for robot navigation and patch cleanup.
```bash
http://localhost:8080/api/v1/robot/cleanUp
```
You can try it out by filling the request like below:
```bash
{
  "roomSize": [
    5,5
  ],
  "coords": [
    1,1
  ],
  "patches": [
    [
      1,2
    ]
  ],
  "instructions": "NNEENNWW"
}
```

The expected response will be like the following:
```bash
{
  "coords": [
    1,
    5
  ],
  "patches": 1
}
```
The navigation will be like the following example:
```bash
Moved up: (1, 2)
Patch cleaned: (1, 2) with patch number: 1
Moved up: (1, 3)
Moved right: (2, 3)
Moved right: (3, 3)
Moved up: (3, 4)
Moved up: (3, 5)
Moved left: (2, 5)
Moved left: (1, 5)
Final position: (1, 5)
```

### 4 **Testing:**
You can run the unit tests using:
```bash
mvn test
