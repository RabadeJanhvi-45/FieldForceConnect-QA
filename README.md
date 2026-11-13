
# FieldForceConnect - QA Automation

This project is part of a QA Automation assignment. It focuses on testing the FieldForceConnect application using Java and Playwright.

## Tech Stack
- Java 17
- Playwright
- Cucumber (BDD)
- TestNG
- Maven

## Automated Test Scenarios

### Login
- Open the login page.
- Enter valid credentials.
- Verify successful login and dashboard navigation.

### Add Customer
- Navigate to My Customers.
- Open the New Customer form.
- Enter customer name.
- Verify the entered name.
- Click Save.

## Project Structure

- `pages` – Page locators and actions
- `stepdefinitions` – Cucumber step definitions
- `features` – Gherkin feature files
- `hooks` – Browser setup and teardown

## Project Architecture

The project follows a simple Page Object Model (POM) structure to keep the automation code organized and easy to maintain.

```text
FielForceConnect-QA
│
├── src/test/java
│   └── com.fieldforce.qa
│       ├── hooks          - Browser setup and closing
│       ├── pages          - Interactions with application pages
│       ├── stepdefinitions - Actions performed during tests
│       ├── runners        - Executes test scenarios
│       └── utilities      - Reusable helper methods
│
├── src/test/resources
│   └── features           - Test scenarios written in simple English
│
├── pom.xml                - Project dependencies and configuration
└── README.md              - Project documentation
```

### How It Works

1. **Feature Files:** Describe what needs to be tested in simple English.
2. **Step Definitions:** Connect each test step to Java code.
3. **Page Objects:** Handle browser actions such as clicking buttons and entering data.
4. **Hooks:** Start and close the browser before and after tests.
5. **Test Runner:** Executes the test scenarios and reports results.


## How to Run

Clone the repository:

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

Run the tests:

```bash
mvn test
```

## Configuration

Create a `.env` file in the project root with your test credentials:

```env
FFC_VALID_USERNAME=your_username
FFC_VALID_PASSWORD=your_password
```

Do not commit credentials to GitHub.




