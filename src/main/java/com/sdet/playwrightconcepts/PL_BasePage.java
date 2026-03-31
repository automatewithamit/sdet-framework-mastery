package com.sdet.playwrightconcepts;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class PL_BasePage {
    static Playwright playwright;
    static Browser browser;
    //setUp
    public static Browser initializeBrowser(){
        playwright = Playwright.create();

        // Launch browser with options
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)   // show UI
                        .setSlowMo(500)       // slow down actions (debugging)
        );
        return browser;
    }
    //tearDownMethod
//    public static void closeBrowser(){
//        browser.close();
//        playwright.close();
//    }
}
