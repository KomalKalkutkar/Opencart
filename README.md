
# OpenCart Automation Project

This is a real-world QA automation project using the **TutorialsNinja (OpenCart)** demo e-commerce application. It automates key user flows using **Java**, **Selenium WebDriver**, and **TestNG**, structured with a clean Page Object Model and reusable utility components.
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

## 📁 Project Structure

```
OpenCartAutomation/
├── screenshots/                     # Captures screenshots on test failure
├── testData/                        # Excel files for test data
│   ├── LoginTestExcelData.xlsx
│   └── OpenCart TestCases.xlsx
├── logs/                            # Log files generated using Log4j2
│   └── automation.log
├── reports/                         # Custom reports (ExtentReports output)
│   └── ExtentReport.html
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pageObjects/         # Page Object Model classes
│   │           ├── AccountRegistrationPage.java
│   │           ├── AddToCartPage.java
│   │           ├── BasePage.java
│   │           ├── CheckoutPage.java
│   │           ├── HomePage.java
│   │           ├── LoginPage.java
│   │           ├── MyAccountPage.java
│   │           ├── SearchPage.java
│   │           └── ShoppingCartPage.java
│   └── resources/                   # Config, test data, log4j, etc.
├── src/
│   └── test/
│       └── java/
│           ├── testCases/          # All test classes
│           │   ├── BaseClass.java
│           │   ├── TC001_AccountRegisterTest.java
│           │   ├── TC002_LoginTest.java
│           │   ├── TC003_LoginDataDrivenTest.java
│           │   ├── TC004_SearchTest.java
│           │   ├── TC005_AddToCartTest.java
│           │   ├── TC006_ShoppingCartTest.java
│           │   └── TC007_CheckOutTest.java
│           └── utilities/          # Common utility classes
│               ├── ExcelUtility.java
│               ├── DataProviders.java
│               └── ExtentReportManager.java
├── test-output/                     # Auto-generated test outputs (TestNG)
└── pom.xml                          # Maven dependencies and config
```


## How to Run the Project

1. Clone this repository or download the source code.  
2. Import the project into IntelliJ IDEA or Eclipse.  
3. Update the `config.properties` file with appropriate values (browser, URL, etc.).  
4. Install dependencies using: `mvn clean install`  
5. Run the tests using: `mvn test` or run via `testngmaster.xml` file in the IDE.

### ✅ Functional Test Cases Covered

| Test Case ID | Description                    |
|--------------|--------------------------------|
| TC001        | Account registration           |
| TC002        | User login                     |
| TC003        | Login with data-driven testing |
| TC004        | Product search                 |
| TC005        | Add product to cart            |
| TC006        | Validate cart page             |
| TC007        | Checkout flow                  |


## Reporting & Logs

- Test logs can be found under the `logs/` directory.  
- Execution reports are generated in the `reports/` folder using ExtentReports.  
- Screenshots on failure are stored under the `screenshots/` folder.

## Author

**Komal A Kalkutkar**  

