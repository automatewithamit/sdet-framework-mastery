package com.sdet.framework.webelements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;

public class ElementActions {
    public void click(Locator buttonLocator) {
        System.out.println("Button with locator "+ buttonLocator +"clicked successfully.");
        buttonLocator.click();
        //page.waitForLoadState(LoadState.NETWORKIDLE);
        System.out.println("Button clicked successfully.");
    }
    public void enterText(Locator textBoxLocator, String text) {
        System.out.println("Entering text: " + text + " into locator: " + textBoxLocator);
        textBoxLocator.fill(text);
        System.out.println("Text entered successfully.");
    }
    public void selectOption(Locator dropdownLocator, String optionValue) {
        System.out.println("Selecting option: " + optionValue + " from locator: " + dropdownLocator);
        dropdownLocator.selectOption(optionValue);
        System.out.println("Option selected successfully.");
    }

}
