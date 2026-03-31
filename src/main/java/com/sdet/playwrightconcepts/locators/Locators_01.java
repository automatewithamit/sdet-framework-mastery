package com.sdet.playwrightconcepts.locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.sdet.playwrightconcepts.PL_BasePage;

public class Locators_01 extends PL_BasePage {


    public static void main(String[] args) {

        Browser browser = initializeBrowser();
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        page.locator("//input[@name='username']") //-> Not locating webelement at this point
        //FindElement("wrongxpath") -> NoSuchElement
        //StaleElementReference
        //FindElements -> List of WebElement

                .fill("Admin");
        page.locator("input[name='password']").fill("admin123");
        //page.locator("button[type='submit']").click();
        page.getByRole(AriaRole.BUTTON).click();
        page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Admin")).click();
        // Print title
        System.out.println("Title: " + page.title());

        page.waitForTimeout(5000);
        context.close();
        /*



        oneTimeSetup ->
        setUp -> Test1 -> tearDown ->
        setUp -> Test2 -> tearDown ->
        setUp -> Test3 -> tearDown ->

        oneTimeTearDown ->

        * oneTimeSetup()
        *
        * setUp()
        *
        * Test1()
        *
        * tearDown()
        *
        * oneTimeTearDown()
        * */

    }
}
