package com.sdet.playwrightconcepts.locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class LocatorPractice {
    public static void main(String[] args) {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context  = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/inputs");
        page.waitForLoadState();
        //Locator inputBox = page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Number"));
        Locator inputBox = page.locator("input[type='Number']");
        inputBox.fill("200");
        page.navigate("https://the-internet.herokuapp.com/");
        Locator listItems = page.getByRole(AriaRole.LISTITEM);

        System.out.println("List items Found : " + listItems.count());

        Locator hoverLink = listItems.filter(new Locator.FilterOptions().setHasText("Hovers"));
        System.out.println("hoverLink items Found : " + hoverLink.count());
        hoverLink.click();

    }
}
