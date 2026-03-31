package com.sdet.playwrightconcepts;

import com.microsoft.playwright.*;

public class P005_ParallelTeests {

        public static void main(String[] args) {

            Playwright playwright = Playwright.create();

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(200));

            // Session 1
            BrowserContext c1 = browser.newContext();
            Page p1 = c1.newPage();

            // Session 2
            BrowserContext c2 = browser.newContext();
            Page p2 = c2.newPage();

            p1.navigate("https://google.com");
            p2.navigate("https://yatra.com");

            System.out.println("Parallel sessions running!");
            p1.waitForTimeout(5000);
            p2.waitForTimeout(5000);
            browser.close();
            playwright.close();
        }
    }

