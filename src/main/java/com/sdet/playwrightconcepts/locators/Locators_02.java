package com.sdet.playwrightconcepts.locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.sdet.playwrightconcepts.PL_BasePage;

public class Locators_02 extends PL_BasePage {
    static BrowserContext context;
    static Browser browser;
    static Page page;
    public static void main(String[] args) {

        loginToORangeHRM();
        createUser();
        page.close();
        context.close();
    }

    public static void loginToORangeHRM(){
         browser = initializeBrowser();
         context = browser.newContext();
         page = context.newPage();

        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        page.locator("//input[@name='username']")
                .fill("Admin");
        page.locator("input[name='password']").fill("admin123");
        //page.locator("button[type='submit']").click();
        page.getByRole(AriaRole.BUTTON).click();
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Admin")).click();


        // Print title
        System.out.println("URL of the Page : " + page.url());




    }

    public static void createUser(){
        page.getByText("-- Select --").nth(1).click();


    }
}
