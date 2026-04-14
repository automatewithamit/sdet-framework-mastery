package com.sdet.framework.webelements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.sdet.framework.core.PlaywrightManager;

public class TextBox {
    Locator textBoxLocator;
    Page page;
    public TextBox(String locatorString) {
        page = PlaywrightManager.getPage();
        textBoxLocator = page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName(locatorString));
    }
    //make this method async and return a future

    public  void enterText(String text) {
        //Code to enter text in the text box in playwright
         page.locator("input#username").fill("testuser");
    }

    public void clearText() {

    }

     public void getText() {

     }
}
