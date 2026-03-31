package com.sdet.playwrightconcepts;
import com.microsoft.playwright.*;

import java.util.ArrayList;

public class P003_MaximizeBrowser {

        public static void main(String[] args) {

            Playwright playwright = Playwright.create();

            ArrayList<String> arguments = new ArrayList<>();

            arguments.add ("--start-maximized");
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false)
                    .setArgs(arguments));

            // Create context with full screen viewport
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions()
                            .setViewportSize(null) // null → full screen
            );

            Page page = context.newPage();

            page.navigate("https://www.yatra.com");
            // Print title
            System.out.println("Title: " + page.title());
            browser.close();
            playwright.close();
        }
    }

