# AGENTS.md - SauceDemo Selenium POM Framework

## Architecture Overview
This is a Maven-based Selenium automation framework using Page Object Model (POM) for testing the SauceDemo e-commerce site. Key components:
- **DriverFactory** (`src/main/java/factory/DriverFactory.java`): Manages WebDriver instances with ThreadLocal for thread safety in parallel execution
- **BasePage** (`src/main/java/pages/BasePage.java`): Base class for all page objects with PageFactory initialization and common element interactions
- TestNG for test execution with ExtentReports for detailed reporting

## Key Patterns
- **Page Object Model**: Each page extends BasePage, uses @FindBy annotations for element locators
- **Element Interactions**: Always use `waitForElement()` before interacting to ensure visibility (10s timeout)
- **Driver Management**: Call `DriverFactory.initDriver()` in test setup, access via `DriverFactory.getDriver()`
- **Headless Chrome**: Default configuration with `--headless=new` and optimized flags for CI/CD

## Dependencies & Versions
- Selenium 4.18.1
- TestNG 7.9.0
- ExtentReports 5.1.1
- Log4j 2.22.1/2.25.3
- Commons-io 2.15.1

## Build & Test Workflow
- **Compile**: `mvn clean compile`
- **Run Tests**: `mvn clean test` (uses `testng.xml` suite file)
- **Generate Reports**: ExtentReports output in `test-output/` directory
- **Debug Mode**: Remove `--headless=new` from DriverFactory for local GUI testing

## Conventions
- Page classes in `src/main/java/pages/`, extend BasePage
- Test classes in `src/test/java/tests/`, use TestNG annotations
- Element locators: Prefer CSS selectors over XPath
- Logging: Use Log4j for test execution logs
- Screenshots: Use commons-io for failure captures

## Example Usage
```java
// In test setup
WebDriver driver = DriverFactory.initDriver();
driver.get("https://www.saucedemo.com/");

// Page class example
public class LoginPage extends BasePage {
    @FindBy(id = "user-name") WebElement usernameField;
    
    public void enterUsername(String username) {
        waitForElement(usernameField).sendKeys(username);
    }
}
```
