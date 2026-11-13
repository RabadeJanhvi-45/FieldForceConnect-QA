
package com.fieldforce.qa.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void waitForLoginPage() {
        page.locator("input[name='username']").waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(30000)
        );
    }

    public void enterUsername(String username) {
        Locator usernameField = page.locator("input[name='username']");

        usernameField.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(15000)
        );

        usernameField.fill(username);
    }

    public void enterPassword(String password) {
        Locator passwordField = page.locator("input[name='password']");

        passwordField.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(15000)
        );

        passwordField.fill(password);
    }

    public void clickSignIn() {

        Locator signInButton = page.locator(
                "button[type='submit']:has-text('Sign In')"
        );

        signInButton.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(30000)
        );

        page.waitForCondition(
                () -> signInButton.isEnabled(),
                new Page.WaitForConditionOptions().setTimeout(15000)
        );

        signInButton.click();
    }
}
