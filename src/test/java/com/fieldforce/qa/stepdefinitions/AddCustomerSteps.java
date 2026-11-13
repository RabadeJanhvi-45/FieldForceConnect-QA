
package com.fieldforce.qa.stepdefinitions;

import com.fieldforce.qa.hooks.Hooks;
import com.fieldforce.qa.pages.AddCustomerPage;
import com.microsoft.playwright.Locator;
import org.testng.Assert;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AddCustomerSteps {

    private AddCustomerPage addCustomerPage;

    @When("the user navigates to My Customers")
    public void navigateToMyCustomers() {

        addCustomerPage = new AddCustomerPage(Hooks.page);
        addCustomerPage.openMyCustomers();

        System.out.println("Navigated to My Customers");
    }

    @When("the user opens the New Customer form")
    public void openNewCustomerForm() {

        addCustomerPage.openNewCustomerForm();

        System.out.println("Opened New Customer form");
    }

    @When("the user enters customer name {string}")
    public void enterCustomerName(String name) {
        addCustomerPage.enterCustomerName(name);
        System.out.println("Customer Name entered: " + name);
    }

    @When("the user enters reference number {string}")
    public void enterReferenceNumber(String refNo) {
        addCustomerPage.enterReferenceNumber(refNo);
        System.out.println("Reference Number entered: " + refNo);
    }

    @When("the user enters contact person {string}")
    public void enterContactPerson(String name) {
        addCustomerPage.enterContactPerson(name);
        System.out.println("Contact Person entered: " + name);
    }

    @When("the user enters mobile number {string}")
    public void enterMobileNumber(String mobile) {
        addCustomerPage.enterMobileNumber(mobile);
        System.out.println("Mobile Number entered: " + mobile);
    }

    @When("the user enters telephone number {string}")
    public void enterTelephoneNumber(String telephone) {
        addCustomerPage.enterTelephoneNumber(telephone);
        System.out.println("Telephone Number entered: " + telephone);
    }

    @When("the user enters email {string}")
    public void enterEmail(String email) {
        addCustomerPage.enterEmail(email);
        System.out.println("Email entered: " + email);
    }

    @When("the user enters designation {string}")
    public void enterDesignation(String designation) {
        addCustomerPage.enterDesignation(designation);
        System.out.println("Designation entered: " + designation);
    }

    @When("the user enters contact location {string}")
    public void enterContactLocation(String location) {
        addCustomerPage.enterContactLocation(location);
        System.out.println("Contact Location entered: " + location);
    }

    @When("the user scrolls down before entering address")
    public void scrollBeforeAddress() {
        addCustomerPage.scrollBeforeAddress();
    }
    @When("the user opens the address picker")
    public void openAddressPicker() {
        addCustomerPage.openAddressPicker();
    }

    @When("the user selects {string} from the {string} dropdown")
    public void selectDropdownOption(String option, String placeholder) {
        addCustomerPage.selectAutocompleteOption(placeholder, option);
    }
    @When("the user clicks the Save button")
    public void clickSaveButton() {
        addCustomerPage.clickSave();
    }

}
