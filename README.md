# Selenium TestNG Automation Framework

A modern Selenium WebDriver automation framework using TestNG for UI testing.

## 📋 Overview

This project demonstrates a professional test automation framework with:
- **Page Object Model (POM)** pattern for maintainable tests
- **Explicit waits** for reliable test execution
- **TestNG** for structured test organization
- **ExtentReports** for professional HTML test reports
- **CI/CD integration** with GitHub Actions

## 🛠️ Tech Stack

| Technology | Version |
|------------|---------|
| Java | 17+ |
| Selenium WebDriver | 4.33.0 |
| TestNG | 7.11.0 |
| WebDriverManager | 6.1.0 |
| ExtentReports | 5.1.2 |
| Gson | 2.13.1 |
| Gradle | 7.2+ |

## 📁 Project Structure

```
selenium-testng/
├── src/test/java/
│   ├── pages/              # Page Object classes
│   │   ├── QuoteHomePage.java
│   │   └── LoginPage.java
│   ├── tests/              # Test classes
│   │   ├── BaseTest.java
│   │   ├── AddQuoteTestPageObj.java
│   │   ├── ColorSelectionTest.java
│   │   └── QuoteValidationTest.java
│   └── utils/              # Utility classes
│       ├── ConfigReader.java
│       ├── WebDriverFactory.java
│       ├── WaitUtils.java
│       └── ExtentReportManager.java
├── config.properties       # Application configuration
├── build.gradle            # Gradle dependencies
└── .github/workflows/      # CI/CD pipelines
```

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Gradle 7.2+
- Chrome/Firefox browser

### Installation

1. Clone the repository
2. Navigate to project directory
3. Build the project:

```bash
./gradlew build
```

### Running Tests

Run all tests:
```bash
./gradlew test
```

Run specific test class:
```bash
./gradlew test --tests ColorSelectionTest
```

Run specific test method:
```bash
./gradlew test --tests ColorSelectionTest.addQuoteWithRedColor
```

### Configuration

Edit `config.properties` to customize:

```properties
app.url=http://bdd.atlasid.tech/
browser=chrome
timeout=10
headless=false
```

## 📊 Test Reports

Test reports are generated in `reports/` directory:
- HTML reports with ExtentReports
- XML results for CI/CD integration

View latest report:
```bash
open reports/TestReport_*.html
```

## ✅ Test Scenarios

| Test Class | Description |
|------------|-------------|
| `AddQuoteTestPageObj` | Add quotes with different colors, verify persistence |
| `ColorSelectionTest` | Test all available color options |
| `QuoteValidationTest` | Test edge cases (special chars, unicode, long text) |

## 🔧 Utilities

### WebDriverFactory
Handles WebDriver initialization for Chrome/Firefox with configurable options.

### WaitUtils
Custom explicit wait utilities for reliable element interactions.

### ExtentReportManager
Manages ExtentReports for professional test documentation.

### ConfigReader
Centralized configuration management for test execution.

## 📦 CI/CD

GitHub Actions workflow automatically:
- Runs tests on push/PR to master
- Generates and uploads test reports
- Publishes test results

## 🎯 Best Practices

- **Page Object Model**: Separate page logic from test logic
- **Explicit Waits**: Never use `Thread.sleep()`
- **Configuration**: Externalize test data and settings
- **Reporting**: Always log test steps and results
- **Single Responsibility**: Each test method should test one thing

## 📝 License

MIT License
