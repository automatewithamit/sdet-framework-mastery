package com.sdet.framework.webelements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.sdet.framework.core.PlaywrightManager;

public class Button implements IButton{
    Locator buttonLocator;
    Page page;

    public Button(String locatorString) {
        page = PlaywrightManager.getPage();
        buttonLocator = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName(locatorString));
    }
    public void click(Locator buttonLocator) {
        try{
        System.out.println("Button with locator "+ buttonLocator +"clicked successfully.");
        buttonLocator.click();
        System.out.println("Button clicked successfully.");
        }
        catch(Exception e){
            System.out.println("Failed to click the button with locator: " + buttonLocator);
            e.printStackTrace();
        }
    }
    public boolean isEnabled(Locator buttonLocator) {
        boolean enabled = buttonLocator.isEnabled();
        System.out.println("Button enabled status: " + enabled);
        return enabled;
    }

    @Override
    public void click() {
        System.out.println("Button with locator "+ buttonLocator +"clicked successfully.");
        buttonLocator.click();
        System.out.println("Button clicked successfully.");
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return "";
    }
}
