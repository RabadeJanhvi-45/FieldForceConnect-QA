
package com.fieldforce.qa.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

public class AddCustomerPage {

    private final Page page;

    public AddCustomerPage(Page page) {
        this.page = page;
    }

    // Navigate to My Customers
    public void openMyCustomers() {
        page.locator("a[href='/']")
                .filter(new Locator.FilterOptions()
                        .setHasText("My Customers"))
                .click();

        page.locator("a[href='/customers']").waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
        );

        page.locator("a[href='/customers']").click();
    }

    // Open New Customer form
    public void openNewCustomerForm() {
        page.getByRole(
                com.microsoft.playwright.options.AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Manage")
        ).click();

        page.getByRole(
                com.microsoft.playwright.options.AriaRole.MENUITEM,
                new Page.GetByRoleOptions().setName("New Customer")
        ).click();

        page.locator("input[name='LeadName']").waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
        );
    }

    // Scroll down before entering address
    public void scrollBeforeAddress() {
        page.mouse().wheel(0, 450);
        page.waitForTimeout(500);
        System.out.println("Scrolled down before Address");
    }

    // Scroll down before entering Tags
    public void scrollBeforeTags() {
        page.mouse().wheel(0, 450);
        page.waitForTimeout(500);
        System.out.println("Scrolled down before Tags");
    }

    // Customer details
    public void enterCustomerName(String name) {
        page.locator("input[name='LeadName']").fill(name);
    }

    public void enterReferenceNumber(String refNo) {
        page.locator("input[name='RefNo']").fill(refNo);
    }

    public void enterContactPerson(String name) {
        page.locator("input[name='PersonName']").fill(name);
    }

    public void enterMobileNumber(String mobile) {
        page.locator("input[name='MobileNo']").fill(mobile);
    }

    public void enterTelephoneNumber(String telephone) {
        page.locator("input[name='ContactNo']").fill(telephone);
    }

    public void enterEmail(String email) {
        page.locator("input[name='Email']").fill(email);
    }

    public void enterDesignation(String designation) {
        page.locator(
                "input[placeholder='Enter Contact Person Designation']"
        ).fill(designation);
    }

    public void enterContactLocation(String location) {
        page.locator("input[name='PersonLocation']").fill(location);
    }

    // Address
    public void openAddressPicker() {
        Locator addressField = page.locator("input[name='Address']");

        addressField.waitFor(
                new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE)
        );

        if (!addressField.isEnabled()) {
            throw new RuntimeException("Address field is not enabled");
        }

        addressField.click();

        System.out.println("[PASS] Address picker opened");
    }
    public void selectAutocompleteOption(String placeholder, String option) {
        Locator dropdown = page.locator(
                "input[role='combobox'][placeholder='" + placeholder + "']"
        );

        dropdown.waitFor(
                new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE)
        );

        dropdown.click();

        dropdown.fill(option);

        Locator optionToSelect = page.getByRole(
                AriaRole.OPTION,
                new Page.GetByRoleOptions().setName(option)
        );

        optionToSelect.waitFor(
                new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE)
        );

        optionToSelect.click();

        System.out.println("[PASS] Selected " + option + " from " + placeholder);
    }
    public void enterPincode(String pincode) {
        page.locator("input[name='PinCode']").fill(pincode);
    }

    public void enterWebsite(String website) {
        page.locator("input[name='Website']").fill(website);
    }

    public void clickMapDone() {

        Locator doneButton = page.getByRole(
                com.microsoft.playwright.options.AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Done")
        );

        doneButton.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(15000)
        );

        doneButton.scrollIntoViewIfNeeded();

        if (!doneButton.isEnabled()) {
            throw new RuntimeException(
                    "Map Done button is visible but disabled. Select a location first."
            );
        }

        doneButton.click();

        System.out.println("Clicked Done in map picker");
    }
    // Tags
    // Open Tags selection popup
    public void openTagsPicker() {

        Locator tagsField = page.locator(
                "input[placeholder='Enter Tags']"
        );

        tagsField.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
        );

        tagsField.click();

        System.out.println("Clicked Tags field - opening Tags picker");
    }

    public void enterOtherInformation(String information) {
        page.locator("input[name='OtherInfo']").fill(information);
    }
    // Click Save button
    public void clickSave() {
        Locator saveButton = page.locator("button[type='button']")
                .filter(new Locator.FilterOptions()
                        .setHasText("Save"));

        saveButton.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
        );

        if (!saveButton.isEnabled()) {
            throw new RuntimeException("Save button is disabled");
        }

        saveButton.click();

        System.out.println("[PASS] Save button clicked");
    }
}
