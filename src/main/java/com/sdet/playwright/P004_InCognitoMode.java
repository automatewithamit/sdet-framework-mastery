package com.sdet.playwright;

import com.microsoft.playwright.*;

public class P004_InCognitoMode {


        public static void main(String[] args) {

            Playwright playwright = Playwright.create();

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                            .setHeadless(false)   // show UI
                            .setSlowMo(500) );      // slow down actions (debugging));

            // Each context is like incognito window
            BrowserContext context = browser.newContext();

            Page page = context.newPage();

            page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            // Print title
            System.out.println("Title: " + page.title());

        }
    }
