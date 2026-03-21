package com.sdet.playwright;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;
public class P004_NonInCognitoMode {



      //Persistent Context
        public static void main(String[] args) {

            Playwright playwright = Playwright.create();

            // Launch persistent browser (like normal Chrome)
            BrowserType.LaunchPersistentContextOptions options =
                    new BrowserType.LaunchPersistentContextOptions()
                            .setHeadless(false);

            BrowserContext context = playwright.chromium()
                    .launchPersistentContext(
                            Paths.get("user-data"), // stores session
                            options
                    );

            Page page = context.newPage();

            page.navigate("https://www.yatra.com");
            // Print title
            System.out.println("Title: " + page.title());
//            context.close();
//            playwright.close();
        }
    }

