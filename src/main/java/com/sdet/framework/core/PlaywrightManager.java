package com.sdet.framework.core;

import com.microsoft.playwright.*;
import com.sdet.framework.helper.PropertiesReader;

public class PlaywrightManager {
    //SOLID Principles
    // - Single Responsibility Principle (SRP)
    // - This class is responsible for managing the browser lifecycle and providing access to the Page object.
    // - Open/Closed Principle (OCP)
    // - The class is open for extension (you can add support for new browsers) but closed for modification (you don't need to change existing code to add new functionality).
    // - Liskov Substitution Principle (LSP)
    // - The class can be used in place of any of its components (Browser, BrowserContext, Page) without affecting the correctness of the program.

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    //WebDriver driver = new ChromeDriver();
    public static void initializeBrowser() {
        String browserName = PropertiesReader.getProperty("browserName", "chromium");

        System.out.println("Browser Name: " + browserName);
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        if (playwright == null) {
            playwright = Playwright.create();
        }

        //write code to launch browser using playwright
        if (browserName.equalsIgnoreCase("chromium")) {

            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
        } else if (browserName.equalsIgnoreCase("chrome")) {

            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless).setChannel("chrome"));
        } else if (browserName.equalsIgnoreCase("firefox")) {

            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
        } else if (browserName.equalsIgnoreCase("webkit")) {

            browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
        } else {
            System.out.println("Invalid browser name: " + browserName + ". Launching default browser (chromium)");
        }

    }

    public static BrowserContext getContext() {
        if (browser == null) {
            throw new RuntimeException("Browser not initialized. Call initializeBrowser() first.");
        }
        if (context == null) {
            context = browser.newContext();
        }
        return context;
    }

    public static Page getPage() {
        if (page == null) {
            throw new RuntimeException("Browser not initialized. Call initializeBrowser() first.");
        }
        page = context.newPage();
        return page;
    }

    public static void closeContext() {
        try {
            if (context != null) {
                context.close();
                context = null;
                System.out.println("Browser context closed successfully");
            }
        } catch (Exception e) {
            System.err.println("Error closing browser context: " + e.getMessage());
        }
    }

    public static void closePage(){
        try {
            if (page != null) {
                page.close();
                page = null;
                System.out.println("Page closed successfully");
            }
        } catch (Exception e) {
            System.err.println("Error closing page: " + e.getMessage());
        }
    }

    public static void closeBrowser() {
        try {
            if (page != null) {
                page.close();
                page = null;
            }
            if (context != null) {
                context.close();
                context = null;
            }
            if (browser != null) {
                browser.close();
                browser = null;
            }
            if (playwright != null) {
                playwright.close();
                playwright = null;
            }
            System.out.println("Browser closed successfully");
        } catch (Exception e) {
            System.err.println("Error closing browser: " + e.getMessage());
        }

    }
}
