# Assignment Project

This project is a Java-based automation testing framework designed to test various functionalities of a web application. The project uses **Selenium** for browser automation, **TestNG** for organizing and running tests, and other utility classes to handle various tasks like Excel data management and browser configuration.

## Project Structure

- **`pages`**: Contains Page Object Model (POM) classes representing different pages in the web application.
  - **AddToCartPage.java**: Page Object Model class representing the "Add to Cart" page.
  - **AppleStorePage.java**: Represents the Apple Store page.
  - **BaseUrl.java**: Holds base URL configurations or methods.
  - **HomePage.java**: Represents the homepage of the application.
  - **MobilePage.java**: Represents the mobile page for product details or listings.
  - **SearchPage.java**: Represents the search results page.

- **`tests/searchTest`**: Contains test cases related to the search functionality.

- **`utilities`**: Includes helper classes:
  - **BrowserFactory.java**: Manages browser initialization and setup (e.g., Chrome, Firefox).
  - **ExcelUtilities.java**: Provides methods to read and write data to Excel files.
  - **PriceFilterDataProvider.java**: Supplies price filter data for parameterized tests, likely used to test filtering on price ranges.
  - **TestNGUtilities.java**: Contains utility methods related to TestNG, such as data providers or custom assertions.

- **Other Directories and Files**:
  - **`target`**: Stores compiled code and test results by Maven.
  - **`PriceRanges.xlsx`**: Excel file containing data for price ranges, possibly used in price filtering tests.
  - **`testng.xml`**: TestNG configuration file defining the test suite and specifying which tests to run.
  - **`.gitignore`**: Lists files and folders to be ignored by Git.
  - **`pom.xml`**: Maven configuration file that manages project dependencies and build configurations.

## Prerequisites

- **Java JDK** (version 8 or later)
- **Maven** for managing dependencies and build processes
- **Selenium WebDriver** for browser automation
- **TestNG** for managing test cases
- **Apache POI** for handling Excel files

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd Assignment

2. **Install dependencies: Ensure all required dependencies are listed in the pom.xml file. Use Maven to download and manage them.**
   ```bash
   mvn clean install
   
3. **Configure the testng.xml file:**

  The testng.xml file is used to define and organize test cases. Customize it to include or exclude specific tests as needed.
  Running Tests
  To run tests, use the following command:
  ```bash
  mvn test
  ```
  Or, to run tests with TestNG directly:
  
  ```bash
  mvn -Dtestng.xml test
  ```

## Project Components
Page Object Model (POM)
- The pages directory contains POM classes for different web pages. Each class encapsulates interactions and elements of a specific page, promoting modular and maintainable code.

Utilities
The utilities directory includes helper classes:

- **BrowserFactory**: Initializes the browser drivers.
- **ExcelUtilities**: Manages Excel data for parameterized tests.
- **PriceFilterDataProvider**: Provides price filtering data for tests.
- **TestNGUtilities**: Custom TestNG utility methods for handling data and test configurations.
