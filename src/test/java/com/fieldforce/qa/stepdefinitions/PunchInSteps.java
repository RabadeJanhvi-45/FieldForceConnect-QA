
package com.fieldforce.qa.stepdefinitions;

import com.fieldforce.qa.hooks.Hooks;
import com.fieldforce.qa.pages.PunchInPage;

import io.cucumber.java.en.Then;

import org.testng.Assert;

public class PunchInSteps {

    private final PunchInPage punchInPage =
            new PunchInPage(Hooks.page);

    private String toastMessage;

    @Then("the user should see the login success toast")
    public void verifyLoginSuccessToast() {

        System.out.println("\n[STEP] Verifying login success toast...");

        try {
            toastMessage = punchInPage.getLoginSuccessToast();

            Assert.assertEquals(
                    toastMessage,
                    "Login Successful",
                    "Login success toast message does not match"
            );

            System.out.println("[PASS] Login success toast displayed: " + toastMessage);

        } catch (Exception e) {
            System.out.println("[FAIL] Login success toast verification failed: "
                    + e.getMessage());
            throw e;
        }
    }

    @Then("the user should be redirected to the dashboard")
    public void verifyDashboardNavigation() {

        System.out.println("\n[STEP] Verifying dashboard navigation...");

        try {
            boolean dashboardDisplayed =
                    punchInPage.isDashboardDisplayed();

            Assert.assertTrue(
                    dashboardDisplayed,
                    "User should be redirected to the dashboard"
            );

            System.out.println("[PASS] Dashboard navigation successful");
            System.out.println("[INFO] Current URL: " + Hooks.page.url());

        } catch (Exception e) {
            System.out.println("[FAIL] Dashboard navigation failed: "
                    + e.getMessage());
            throw e;
        }
    }
}
