package com.sdet.playwrightconcepts;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.io.File;

public class P004_NonInCognitoMode {


    //Persistent Context
    public static void main(String[] args) {

//        killBrowserProcesses();
//        persistentLogin();
        //setupLogin();
        testAsLoggedInUser();
    }
    public static void testAsLoggedInUser() {
        Playwright pw = Playwright.create();
        // It points to the same "my-session" folder!
        BrowserContext context = pw.webkit().launchPersistentContext(
                Paths.get("browser-session-data"),
                new BrowserType.LaunchPersistentContextOptions().setHeadless(false)
        );

        Page page = context.pages().getFirst();
        page.navigate("https://www.yatra.com");
        page.waitForTimeout(5000);

        // You are already logged in! No need to fill login forms.
    }
    public static void setupLogin() {
        Playwright pw = Playwright.create();
        BrowserContext context = pw.webkit().launchPersistentContext(
                Paths.get("my-session"),
                new BrowserType.LaunchPersistentContextOptions().setHeadless(false)
        );
        Page page = context.newPage();
        page.navigate("https://www.yatra.com");

        page.pause(); // <--- Stop here, log in manually!
        context.close();
    }
    private static void killBrowserProcesses() {
        try {
            // Force kills any hanging WebKit or Chromium processes on Mac
            Runtime.getRuntime().exec("pkill -9 -f WebKit");
            Runtime.getRuntime().exec("pkill -9 -f Chromium");
        } catch (Exception e) {
            System.out.println("No existing processes to kill.");
        }

    }
    private static void cleanUserDataDirectory(String path) {
        try {
            Path directory = Paths.get(path);
            if (Files.exists(directory)) {
                // Recursively delete all files and subfolders
                Files.walk(directory)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                System.out.println("Cleaned existing user-data folder.");
            }
        } catch (Exception e) {
            System.out.println("Could not clean folder: " + e.getMessage());
        }
    }

    public static void persistentLogin() {

        try (Playwright playwright = Playwright.create()) {

            // 1. Define an ABSOLUTE path for your session data
            // This creates a 'user-data' folder in your current project folder
            String userDataPath = Paths.get("user-data").toAbsolutePath().toString();
            System.out.println(userDataPath);
            cleanUserDataDirectory("user-data");
            // 2. Set options (Headed mode is critical for visibility)
            BrowserType.LaunchPersistentContextOptions options =
                    new BrowserType.LaunchPersistentContextOptions()
                            .setHeadless(false);

            // 3. Launch WebKit (for Safari) or Chromium
            // Note: Use webkit() if you want Safari specifically
            BrowserContext context = playwright.chromium()
                    .launchPersistentContext(Paths.get(userDataPath), options);

            Page page = context.newPage();
            page.navigate("https://www.yatra.com");

            System.out.println("Title: " + page.title());

            // 4. STAY OPEN: Forces the browser to stay visible for inspection
            //page.pause();

            // context.close(); // Only close when you are done
        }
    }
}
