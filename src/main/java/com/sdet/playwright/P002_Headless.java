package com.sdet.playwright;

import com.microsoft.playwright.*;

public class P002_Headless {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        // Launch browser with options
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)   // show UI
                        .setSlowMo(500)       // slow down actions (debugging)
        );

        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Print title
        System.out.println("Title: " + page.title());

        browser.close();
        playwright.close();
    }
}
