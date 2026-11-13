
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


