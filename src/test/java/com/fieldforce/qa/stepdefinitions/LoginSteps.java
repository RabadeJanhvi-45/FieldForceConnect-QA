
package com.fieldforce.qa.stepdefinitions;

import com.fieldforce.qa.hooks.Hooks;
import com.fieldforce.qa.pages.LoginPage;
import com.microsoft.playwright.Locator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(Hooks.page);
        loginPage.waitForLoginPage();
    }

    @When("the user enters valid credentials")
    public void enterValidCredentials() {

        String username = System.getenv("FFC_VALID_USERNAME");
        String password = System.getenv("FFC_VALID_PASSWORD");

        Assert.assertNotNull(username,
                "Set environment variable FFC_VALID_USERNAME");

        Assert.assertNotNull(password,
                "Set environment variable FFC_VALID_PASSWORD");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("the user enters invalid credentials")
    public void enterInvalidCredentials() {
        loginPage.enterUsername("invalid@example.com");
        loginPage.enterPassword("WrongPassword123!");
    }

    @When("the user clicks the Sign In button")
    public void clickSignIn() {
        loginPage.clickSignIn();
    }

    @Then("the user should successfully reach the dashboard")
    public void verifyDashboard() {

        Locator usernameField =
                Hooks.page.locator("input[name='username']");

        usernameField.waitFor(
                new Locator.WaitForOptions()
                        .setState(com.microsoft.playwright.options.WaitForSelectorState.HIDDEN)
        );

        Assert.assertFalse(usernameField.isVisible(),
                "Login form should disappear after successful login");
    }

    @Then("the user should see an appropriate error message")
    public void verifyLoginError() {

        Locator errorMessage = Hooks.page.locator(
                "[role='alert'], [role='status']"
        );

        errorMessage.waitFor(
                new Locator.WaitForOptions()
                        .setState(com.microsoft.playwright.options.WaitForSelectorState.VISIBLE)
        );

        Assert.assertTrue(errorMessage.isVisible(),
                "An error message should appear for invalid credentials");
    }
}
