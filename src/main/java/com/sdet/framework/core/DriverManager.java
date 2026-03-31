package com.sdet.framework.core;

import com.microsoft.playwright.*;
import com.sdet.framework.helper.PropertiesReader;

import java.util.Locale;

public class DriverManager {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

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

        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();
        System.out.println("Browser initialized: " + browserName);
    }

    public static Page getPage() {
        if (page == null) {
            throw new RuntimeException("Browser not initialized. Call initializeBrowser() first.");
        }
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
