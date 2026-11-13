
package com.fieldforce.qa.hooks;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.WaitUntilState;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import java.nio.file.Paths;
import java.util.Arrays;

public class Hooks {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    @Before
    public void setUp() {

        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions =
                new BrowserType.LaunchOptions()
                        .setExecutablePath(Paths.get(
                                "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
                        ))
                        .setHeadless(false);

        browser = playwright.chromium().launch(launchOptions);

        // Grant location permission and configure test coordinates
        Browser.NewContextOptions contextOptions =
                new Browser.NewContextOptions()
                        .setPermissions(Arrays.asList("geolocation"))
                        .setGeolocation(new Geolocation(19.0760, 72.8777));

        context = browser.newContext(contextOptions);

        page = context.newPage();

        page.navigate(
                "https://test.fieldforceconnect.com/",
                new Page.NavigateOptions()
                        .setWaitUntil(WaitUntilState.DOMCONTENTLOADED)
                        .setTimeout(60000)
        );
    }

    @After
    public void tearDown() {

        if (context != null) {
            context.close();
        }

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}
