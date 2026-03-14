# TestSelenium Learning Repository

Welcome to the **TestSelenium** repository! This is a comprehensive learning resource for mastering Selenium WebDriver through hands-on exercises. Whether you're a beginner or looking to sharpen your skills, this repo provides structured examples and homework assignments to guide you through automated web testing.

## Overview

This repository is organized into **6 exercises (Ex1-6)**, each focusing on different aspects of Selenium WebDriver. Each exercise includes:
- **Example**: Pre-built code demonstrating key concepts and best practices.
- **Homework**: Assignments for you to implement and practice what you've learned.

The exercises build progressively, starting from basic setup and moving towards advanced topics like waits, page objects, and alerts.

## Prerequisites

Before getting started, ensure you have the following installed:
- **Java JDK** (version 8 or higher)
- **Apache Maven** (for dependency management and running tests)
- **Selenium WebDriver** (included as a dependency)
- **Browser Drivers** (e.g., ChromeDriver, GeckoDriver) matching your browser versions
- **IDE** (e.g., IntelliJ IDEA, Eclipse, or VS Code with Java extensions)

## Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/TestSelenium.git
   cd testselenium
   ```

2. **Install dependencies**:
   ```bash
   mvn clean install
   ```

3. **Configure browser drivers**:
   - Download the appropriate driver for your browser (e.g., [ChromeDriver](https://chromedriver.chromium.org/)).
   - Place the driver executable in your system's PATH or specify the path in your tests.

## Project Structure
```
TestSelenium/
├── pom.xml                          # Maven configuration file
├── resources/                       # Top-level resource files
├── src/
│   ├── main/
│   │   ├── java/                    # Main source code
│   │   │   ├── Ex5/
│   │   │   │   ├── example/
│   │   │   │   │   └── pages/       # Page Object classes for Ex5 examples
│   │   │   │   │       ├── HomePage.java
│   │   │   │   │       ├── LoginPage.java
│   │   │   │   │       └── SecureAreaPage.java
│   │   │   │   └── homework/        # Homework page classes for Ex5
│   │   │   │       ├── HomePage.java
│   │   │   │       ├── LoadingPage.java
│   │   │   │       └── OptionsPage.java
│   │   │   └── Ex6/
│   │   │       ├── example/
│   │   │       │   └── pages/       # Page Object classes for Ex6 examples
│   │   │       │       ├── AlertPage.java
│   │   │       │       └── HomePage.java
│   │   │       └── homework/        # Homework page classes for Ex6
│   │   └── resources/               # Main resources
│   └── test/
│       ├── java/                    # Test source code
│       │   ├── Ex1_2/
│       │   │   └── base/
│       │   │       └── BaseTests.java
│       │   ├── Ex3/
│       │   │   └── homework/
│       │   │       ├── FormyTest.java
│       │   │       ├── OpenQATest.java
│       │   │       ├── SauceTest.java
│       │   │       └── TestPageTest.java
│       │   ├── Ex4/
│       │   │   └── example/
│       │   │       ├── FluentWaitEx.java
│       │   │       └── Im_ExWait.java
│       │   ├── Ex5/
│       │   │   ├── example/
│       │   │   │   ├── BaseTests.java
│       │   │   │   ├── FirstTest.java
│       │   │   │   └── login/
│       │   │   │       └── LoginTests.java
│       │   │   └── homework/
│       │   │       ├── BaseTests.java
│       │   │       └── DynamicLoadingTests.java
│       │   ├── Ex6/
│       │   │   └── example/
│       │   │       ├── BaseTests.java
│       │   │       └── alerts/
│       │   │           └── AlertTests.java
│       │   └── utils/
│       │       └── BaseTest.java
│       └── resources/               # Test resources
└── target/                          # Compiled classes and test results
```

### Exercise Breakdown
- **Ex1_2**: Basic setup and fundamentals (combined for efficiency).
- **Ex3**: Form interactions and basic test scenarios.
- **Ex4**: Explicit, implicit and fluent waits.
- **Ex5**: Page Object Model implementation.
- **Ex6**: Handling alerts and advanced interactions.

## Running Tests

To run all tests:
```bash
mvn test
```

To run tests for a specific exercise (e.g., Ex5):
```bash
mvn test -Dtest=Ex5.*
```

For homework assignments, navigate to the respective test class and run individually in your IDE.

### Example Commands
- Run Ex5 homework tests: `mvn test -Dtest=Ex5.homework.*`
- Run a single test class: `mvn test -Dtest=Ex5.homework.DynamicLoadingTests`

## Learning Path

1. Start with **Ex1_2** to set up your environment and understand basic Selenium concepts.
2. Progress through each exercise, first reviewing the **example** code, then implementing the **homework**.
3. Use the `utils/BaseTest.java` for common test setup and teardown logic.
4. Refer to the page objects in `src/main/java` for best practices in organizing your code.

## Contributing

This is a learning repository, so feel free to:
- Submit pull requests with improvements to examples or additional homework solutions.
- Open issues for questions or suggestions.
- Share your completed homework for peer review.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Happy testing! If you have any questions, check the issues section or reach out. 🚀