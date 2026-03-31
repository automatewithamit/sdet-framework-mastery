package com.sdet.playwrightconcepts;


import com.microsoft.playwright.*;

import java.util.ArrayList;

public class P001_LaunchBrowser {

    public static void main(String[] args) {
        //launchChromiumBrowsers();
        //launchChromeBrowser();
        launchFirefoxBrowser();
        //launchBrowser("chrome");
        //launchBrowser("webkit");
        //launchBrowser("firefox");
        //launchSafariBrowser();

    }
    public static void launchChromiumBrowsers(){
        // Create Playwright engine (entry point)
        Playwright playwright = Playwright.create();

        // Launch Chromium browser
        Browser browser = playwright.chromium().launch();

        // Create a new browser context (fresh session)
        BrowserContext context = browser.newContext();

        // Open a new tab (page)
        Page page = context.newPage();

        // Navigate to website
        page.navigate("https://www.google.com");

        // Print title
        System.out.println("Title: " + page.title());

        // Close browser
        browser.close();

        // Close Playwright engine
        playwright.close();
    }
    public static void launchChromeBrowser() {
        Playwright playwright = Playwright.create();

        // Launch Chromium browser
        Browser browser = playwright.chromium().launch(
                                                        new BrowserType.LaunchOptions()
                                                        .setHeadless(false)
                                                        .setChannel("chrome"));

        // Create a new browser context (fresh session)
        BrowserContext context = browser.newContext();

        // Open a new tab (page)
        Page page = context.newPage();

        // Navigate to website
        page.navigate("https://www.google.com");

        // Print title
        System.out.println("Title: " + page.title());
        //page.wait(5000);
        // Close browser
        browser.close();

        // Close Playwright engine
        playwright.close();
    }
    public static void launchFirefoxBrowser(){
        Playwright playwright = Playwright.create();

        // Launch Chromium browser
        Browser browser = playwright.firefox().launch(
                                                        new BrowserType
                                                        .LaunchOptions()
                                                        .setHeadless(false));

        // Create a new browser context (fresh session)
        BrowserContext context = browser.newContext();

        // Open a new tab (page)
        Page page = context.newPage();

        // Navigate to website
        page.navigate("https://www.yatra.com");

        // Print title
        System.out.println("Title: " + page.title());

        // Close browser
        browser.close();

        // Close Playwright engine
        playwright.close();
    }
    public static void launchSafariBrowser() {
        // 1. Initialize Playwright
        try (Playwright playwright = Playwright.create()) {

            // 2. Launch WebKit (Safari's engine)
            // setHeadless(false) allows you to see the browser UI
            Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false).setSlowMo(2000));

            // 3. Create a new page (tab)
            Page page = browser.newPage();

            // 4. Navigate to a website
            page.navigate("https://www.google.com");

            // 5. Print the page title to verify
            System.out.println("Page Title: " + page.title());

            // 6. Close the browser
            browser.close();
        }
    }

    public static void launchBrowser(String browserName){
        Playwright playwright = Playwright.create();
        Browser browser;
        ArrayList<String> arguments = new ArrayList<>();

        arguments.add ("--start-maximized");
        // Launch Chromium browser
        if(browserName.equals("chrome")|| browserName.equals("msedge")) {
             browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel(browserName).setArgs(arguments));
        }
        else if(browserName.equals("firefox")){
             browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        } else if (browserName.equals("safari")) {
             browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        }
        else {
             browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setArgs(arguments));
        }


        // Create a new browser context (fresh session)
        BrowserContext context = browser.newContext();

        // Open a new tab (page)
        Page page = context.newPage();

        // Navigate to website
        page.navigate("https://www.google.com");

        // Print title
        System.out.println("Title: " + page.title());

        // Close browser
        browser.close();

        // Close Playwright engine
        playwright.close();
    }
}