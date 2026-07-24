
# xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx ???????????????????

# ABA-02 - Product Management API

[![Java](https://img.shields.io/badge/Java-21-blue?logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.0-green?logo=spring-boot)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.16-C71A36?logo=apache-maven)](https://maven.apache.org/)
[![Build Status](https://github.com/marcusvbrangel/aba-02/actions/workflows/ci.yml/badge.svg)](https://github.com/marcusvbrangel/aba-02/actions/workflows/ci.yml)
[![Tests](https://img.shields.io/badge/Tests-35%2F35%20Passing-brightgreen)](./src/test)
[![Coverage](https://img.shields.io/badge/Coverage-Monitored-blue)](https://codecov.io)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📋 Overview

Product Management API built with **Spring Boot 3.4** and **Java 21**. This project implements a complete REST API for managing products with comprehensive testing and CI/CD automation.

## ✨ Features

- ✅ **Product Model** - Complete entity with id, name, active status, and price
- ✅ **REST API Endpoints** - Two endpoints for product retrieval
- ✅ **Service Layer** - Business logic separation with ProductService
- ✅ **Active Products Filter** - Returns only active products
- ✅ **35 Comprehensive Tests** - Unit and integration tests
- ✅ **CI/CD Pipeline** - Automated build, test, and coverage with GitHub Actions
- ✅ **Code Coverage** - JaCoCo integration with Codecov
- ✅ **Maven Build** - Fully configured Maven project

## 🏗️ Project Structure

```
src/
├── main/
│   └── java/com/aba02/
│       ├── Aba02Application.java
│       ├── api/
│       │   ├── products.java              (REST endpoint: /api/products)
│       │   └── ProductsController.java    (REST endpoint: /products)
│       ├── model/
│       │   └── Product.java               (Entity model)
│       └── service/
│           └── ProductService.java        (Business logic)
└── test/
    └── java/com/aba02/
        ├── api/
        │   ├── ProductsControllerTest.java
        │   └── ProductsTest.java
        ├── model/
        │   └── ProductTest.java
        └── service/
            └── ProductServiceTest.java
```

## 🚀 Getting Started

### Prerequisites
- Java 21+
- Maven 3.9+

### Build
```bash
mvn clean compile
```

### Run Tests
```bash
mvn test
```

### Generate Code Coverage Report
```bash
mvn jacoco:report
# Report: target/site/jacoco/index.html
```

## 📊 API Endpoints

### 1. Products (REST - JSON)
```http
GET /api/products
```
**Response:** List of active products in JSON format

### 2. Products Controller (REST - JSON)
```http
GET /products
```
**Response:** List of active products with HTTP 200 status

**Sample Response:**
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "active": true,
    "price": 999.99
  },
  {
    "id": 2,
    "name": "Mouse",
    "active": true,
    "price": 29.99
  }
]
```

## 🧪 Testing

### Test Coverage
- **Total Tests:** 35
- **Pass Rate:** 100%
- **Test Types:**
  - Unit Tests (Model & Service): 17
  - Integration Tests (Controllers): 18

### Run Tests with Reports
```bash
mvn clean test
mvn jacoco:report
```

## 🔄 CI/CD Pipeline

### GitHub Actions Workflow
- **Triggers:** Push to main/develop/feature* and Pull Requests
- **Steps:**
  1. Checkout code
  2. Setup Java 21
  3. Compile code
  4. Run tests
  5. Generate test reports
  6. Generate code coverage
  7. Upload to Codecov

**View Workflow:** [.github/workflows/ci.yml](.github/workflows/ci.yml)

## 📈 Data

**Available Products:** 40
- **Active:** 37
- **Inactive:** 3

Sample inactive products:
- Desk Lamp (ID: 7)
- Motherboard (ID: 17)
- Audio Interface (ID: 35)

## 🛠️ Technologies

| Technology | Version |
|-----------|---------|
| Java | 21 (LTS) |
| Spring Boot | 3.4.0 |
| Maven | 3.9.16 |
| JUnit 5 | Latest |
| Mockito | Latest |
| JaCoCo | 0.8.10 |

## 📝 Git Workflow

1. **Create Feature Branch**
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```

2. **Commit Changes**
   ```bash
   git commit -m "feat: descrição da mudança"
   ```

3. **Push to GitHub**
   ```bash
   git push origin feature/nova-funcionalidade
   ```

4. **Create Pull Request**
   - GitHub Actions runs automatically
   - Review code
   - Merge when approved

## 📧 Author

Created with ❤️ by Marcus V. B. Rangel

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

**Last Updated:** 2026-07-24
**Status:** ✅ All tests passing | ✅ CI/CD Active
