package com.fieldforce.qa.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class PunchInPage {

    private final Page page;

    public PunchInPage(Page page) {
        this.page = page;
    }

    public String getLoginSuccessToast() {

        Locator successToast = page.locator(
                "div[role='status'][aria-live='polite']"
        ).filter(
                new Locator.FilterOptions()
                        .setHasText("Login Successful")
        );

        successToast.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(15000)
        );

        return successToast.innerText().trim();
    }

    public boolean isDashboardDisplayed() {

        page.waitForURL(
                "**/dashboard",
                new Page.WaitForURLOptions()
                        .setTimeout(30000)
        );

        return page.url().equals(
                "https://test.fieldforceconnect.com/dashboard"
        );
    }
}