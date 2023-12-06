# Elmenus Technical Task

## Tools used 
![](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![](https://img.shields.io/badge/mysql-316192?style=for-the-badge&logo=mysql&logoColor=white)
![](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![](https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![](https://img.shields.io/badge/IntellijIDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)
![](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![](https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=github&logoColor=white)

## Diagrams
### Database Diagram

![](Doc_res/DatabaseDiagram.png)

## How to run the project




## API Documentation

 Base URL: `http://localhost:8080`

### Note

**Requests must be made with JSON type**

```
Content-Type: application/json
```
## Endpoints
The API supports the following endpoints:

### 1. Get all drones
Returns a list of all drones in the database.

```HTTP
GET /api/drones
```
- Example response:
  ```JSON
  [
    {
        "serialNumber": "AB",
        "model": "Heavyweight",
        "weightLimit": 50,
        "batteryCapacity": 50,
        "state": "DELIVERING",
        "medications": [
            {
                "id": 6,
                "name": "dawaa",
                "code": "123456789",
                "weight": 20,
                "image": "dawaa.jpg"
            },
            {
                "id": 7,
                "name": "bestInTheWest",
                "code": "65433fg",
                "weight": 30,
                "image": "bestInTheWest.jpg"
            }
        ]
    }]
  ```