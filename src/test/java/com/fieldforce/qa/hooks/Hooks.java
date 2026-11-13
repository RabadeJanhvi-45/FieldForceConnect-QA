
package com.fieldforce.qa.hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    public static Playwright playwright;
    public static Browser browser;
    public static Page page;


    @Before
    public void setUp() {
        playwright = Playwright.create();

        BrowserType.LaunchOptions options =
                new BrowserType.LaunchOptions()
                        .setExecutablePath(
                                java.nio.file.Paths.get(
                                        "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
                                )
                        )
                        .setHeadless(false);

        browser = playwright.chromium().launch(options);

        page = browser.newPage();
        page.navigate("https://test.fieldforceconnect.com/");
    }


    @After
    public void tearDown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
