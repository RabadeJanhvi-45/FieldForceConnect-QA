
package com.fieldforce.qa.stepdefinitions;

import com.fieldforce.qa.hooks.Hooks;
import com.fieldforce.qa.pages.LoginPage;
import com.microsoft.playwright.Locator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.cdimascio.dotenv.Dotenv;

import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage;

    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {

        System.out.println("\n[STEP] Opening login page...");

        try {
            loginPage = new LoginPage(Hooks.page);
            loginPage.waitForLoginPage();

            System.out.println("[PASS] Login page loaded successfully");
            System.out.println("[INFO] Current URL: " + Hooks.page.url());

        } catch (Exception e) {
            System.out.println("[FAIL] Login page loading failed: "
                    + e.getMessage());
            throw e;
        }
    }

    @When("the user enters valid credentials")
    public void enterValidCredentials() {

        System.out.println("\n[STEP] Entering valid login credentials...");

        try {
            String username = dotenv.get("FFC_VALID_USERNAME");
            String password = dotenv.get("FFC_VALID_PASSWORD");

            Assert.assertNotNull(username,
                    "Set FFC_VALID_USERNAME in .env");

            Assert.assertNotNull(password,
                    "Set FFC_VALID_PASSWORD in .env");

            loginPage.enterUsername(username);
            System.out.println("[PASS] Username entered successfully");

            loginPage.enterPassword(password);
            System.out.println("[PASS] Password entered successfully");

        } catch (Exception e) {
            System.out.println("[FAIL] Valid credential entry failed: "
                    + e.getMessage());
            throw e;
        }
    }

    @When("the user enters invalid credentials")
    public void enterInvalidCredentials() {

        System.out.println("\n[STEP] Entering invalid login credentials...");

        try {
            loginPage.enterUsername("invalid@example.com");
            System.out.println("[PASS] Invalid username entered");

            loginPage.enterPassword("Wrong@123!");
            System.out.println("[PASS] Invalid password entered");

        } catch (Exception e) {
            System.out.println("[FAIL] Invalid credential entry failed: "
                    + e.getMessage());
            throw e;
        }
    }

    @When("the user clicks the Sign In button")
    public void clickSignIn() {

        System.out.println("\n[STEP] Clicking Sign In button...");

        try {
            loginPage.clickSignIn();

            System.out.println("[PASS] Sign In button clicked");

        } catch (Exception e) {
            System.out.println("[FAIL] Sign In action failed: "
                    + e.getMessage());
            throw e;
        }
    }

    @Then("the user should successfully reach the dashboard")
    public void verifyDashboard() {

        System.out.println("\n[STEP] Verifying successful login...");

        try {
            Locator usernameField =
                    Hooks.page.locator("input[name='username']");

            usernameField.waitFor(
                    new Locator.WaitForOptions()
                            .setState(
                                    com.microsoft.playwright.options.WaitForSelectorState.HIDDEN
                            )
            );

            Assert.assertFalse(
                    usernameField.isVisible(),
                    "Login form should disappear after successful login"
            );

            System.out.println("[PASS] Login successful");
            System.out.println("[INFO] Login form disappeared");
            System.out.println("[INFO] Current URL: " + Hooks.page.url());

        } catch (Exception e) {
            System.out.println("[FAIL] Dashboard verification failed: "
                    + e.getMessage());
            throw e;
        }
    }

    @Then("the user should see an appropriate error message")
    public void verifyLoginError() {

        System.out.println("\n[STEP] Verifying invalid login error toast...");

        try {
            String expectedMessage =
                    "Invalid Email Id / Mobile No or Password.";

            Locator errorToast = Hooks.page.locator(
                    "div[role='status'][aria-live='polite']"
            ).filter(
                    new Locator.FilterOptions()
                            .setHasText(expectedMessage)
            );

            errorToast.waitFor(
                    new Locator.WaitForOptions()
                            .setState(
                                    com.microsoft.playwright.options.WaitForSelectorState.VISIBLE
                            )
                            .setTimeout(10000)
            );

            String actualMessage = errorToast.innerText().trim();

            Assert.assertEquals(
                    actualMessage,
                    expectedMessage,
                    "Invalid login error toast message does not match"
            );

            System.out.println("[PASS] Invalid login error toast displayed");
            System.out.println("[INFO] Toast Message: " + actualMessage);

        } catch (Exception e) {
            System.out.println("[FAIL] Invalid login validation failed: "
                    + e.getMessage());
            throw e;
        }
    }
}
