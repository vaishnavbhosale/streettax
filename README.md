# 🛣️ StreetTax – Route-Based Tax Estimation API

A Spring Boot REST API that estimates road tax for vehicle trips based on distance, vehicle type, and route type. Built with clean layered architecture and production-grade error handling.

---

## 📌 What It Does

Given a source city, destination city, distance, vehicle type, and route type — StreetTax calculates the estimated road tax using a rule-based pricing engine.

**Tax Formula:**
```
Estimated Tax = Distance (km) × Base Rate (₹5/km) × Vehicle Multiplier × Route Multiplier
```

---

## ⚙️ Pricing Rules

### Vehicle Multipliers
| Vehicle Type | Multiplier |
|--------------|------------|
| Bike         | 1.0x       |
| Car          | 1.2x       |
| Truck        | 1.5x       |

### Route Multipliers
| Route Type       | Multiplier |
|------------------|------------|
| State Highway    | 1.0x       |
| National Highway | 1.2x       |
| Expressway       | 1.4x       |

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+

### Run Locally
```bash
git clone https://github.com/vaishnavbhosale/streettax.git
cd streettax
mvn spring-boot:run
```

API will start at: `http://localhost:8080`

---

## 📡 API Reference

### POST `/tax/calculate`

Calculates estimated road tax for a trip.

**Request Body:**
```json
{
  "sourceCity": "Pune",
  "destinationCity": "Mumbai",
  "distanceInKm": 150,
  "vehicleType": "CAR",
  "routeType": "EXPRESSWAY"
}
```

**Success Response (200 OK):**
```json
{
  "sourceCity": "Pune",
  "destinationCity": "Mumbai",
  "distanceInKm": 150,
  "vehicleType": "CAR",
  "estimatedTax": 1260.0
}
```
> **Calculation:** 150 × ₹5 × 1.2 (CAR) × 1.4 (EXPRESSWAY) = ₹1260.0

---

## 🧪 Sample Requests

| Route | Distance | Vehicle | Route Type | Estimated Tax |
|-------|----------|---------|------------|---------------|
| Pune → Mumbai | 150 km | CAR | EXPRESSWAY | ₹1260.0 |
| Delhi → Agra | 200 km | TRUCK | NATIONAL_HIGHWAY | ₹1800.0 |
| Nashik → Shirdi | 90 km | BIKE | STATE_HIGHWAY | ₹450.0 |

---

## ❌ Error Handling

The API returns structured error responses for all failure cases.

**Invalid distance (400 Bad Request):**
```json
{
  "timestamp": "2025-01-15T10:30:00",
  "status": 400,
  "error": "BAD_REQUEST",
  "message": "Distance must be greater than zero",
  "path": "/tax/calculate"
}
```

**Unsupported vehicle/route type (422 Unprocessable Entity):**
```json
{
  "timestamp": "2025-01-15T10:30:00",
  "status": 422,
  "error": "BAD_REQUEST",
  "message": "Vehicle type is not supported",
  "path": "/tax/calculate"
}
```

### Valid Enum Values
- **vehicleType:** `BIKE`, `CAR`, `TRUCK`
- **routeType:** `STATE_HIGHWAY`, `NATIONAL_HIGHWAY`, `EXPRESSWAY`

---

## 🏗️ Project Structure

```
src/main/java/com/streettax/streettax/
├── controller/
│   └── TaxController.java          # REST endpoint
├── service/
│   └── TaxService.java             # Rule-based pricing logic
├── dto/
│   ├── TaxCalculationRequest.java  # Input model
│   ├── TaxCalculationResponse.java # Output model
│   └── ErrorResponse.java          # Structured error model
├── model/
│   ├── VehicleType.java            # Enum: BIKE, CAR, TRUCK
│   └── RouteType.java              # Enum: STATE_HIGHWAY, NATIONAL_HIGHWAY, EXPRESSWAY
├── exception/
│   ├── BadRequestException.java    # Input validation errors
│   ├── BusinessException.java      # Business rule violations
│   └── GlobalExceptionHandler.java # Centralized exception handling
└── StreettaxApplication.java
```

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3**
- **REST API**
- **Maven**
- **Postman** (for testing)

---

## 👤 Author

**Vaishnav Bhosale**  
[LinkedIn](https://linkedin.com/in/Vaishnavbharatbhosale) • [GitHub](https://github.com/vaishnavbhosale)
