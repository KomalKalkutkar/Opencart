
# OpenCart Automation Project

This project is an automated test suite for the **OpenCart** web application. The main functionalities automated include **Account Registration** and **Login**, implemented using Java, Selenium WebDriver, and TestNG with a **Hybrid Framework** approach.

## Technologies Used

- Java  
- Selenium WebDriver  
- TestNG  
- Apache POI (for Excel interaction)  
- Log4j2 (for logging)  
- Extent Reports (for reporting)  
- Maven (for build and dependency management)

## Features Implemented

- **Page Object Model (POM):** Separate classes for page elements and actions.
- **TestNG Framework:** Used for test case management and execution.
- **Data-Driven Testing:** Login test case accepts multiple data sets using `@DataProvider` and Excel utility.
- **Logging with Log4j2:** Captures test logs and debugging information.
- **Reports with Extent Reports:** Generates visually rich HTML test reports.
- **XML-Based Execution:** TestNG XML files control which tests to run.
- **Configuration File:** `config.properties` centralizes environment and browser settings.
- **Screenshot Capture:** Captures screenshots on test failure.
- **Manual Test Cases in Excel:** Separate Excel sheets created for **Login** and **Registration** test scenarios and included in the project under the `testData/` folder.

## How to Run the Project

1. Clone this repository or download the source code.  
2. Import the project into IntelliJ IDEA or Eclipse.  
3. Update the `config.properties` file with appropriate values (browser, URL, etc.).  
4. Install dependencies using: `mvn clean install`  
5. Run the tests using: `mvn test` or run via `testng.xml` file in the IDE.

## Sample Functionalities Automated

- **Account Registration:**
  - Valid form submission
  - Field validations
- **Login:**
  - Valid and invalid login attempts
  - Login with multiple datasets

## Reporting & Logs

- Test logs can be found under the `logs/` directory.  
- Execution reports are generated in the `reports/` folder using ExtentReports.  
- Screenshots on failure are stored under the `screenshots/` folder.

## Author

**Komal A Kalkutkar**  

