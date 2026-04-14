package com.sdet.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

public class NavigationPage extends BasePage {

    Locator dashboardLink = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Dashboard"));
    Locator leaveLink = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Leave"));
    Locator timeLink = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Time"));
    Locator recruitmentLink = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Recruitment"));
    Locator performanceLink = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Performance"));
    Locator adminLink = page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("Admin"));

    // Generic navigation method: clicks the menu option and returns an instance of the requested Page class
    // Why <T extends BasePage> ?
    // It allows the method to return any type of page that extends BasePage, providing flexibility and type safety.
    // The caller can specify the exact page type they expect, and the method will return that type, enabling direct access to page-specific methods without needing casts.
    //How to call this method:
    // AdminPage adminPage = navigationPage.to("Admin", AdminPage.class);
    // Why do we need the second parameter (Class<T> pageClass) when we already have the option string to determine which page to navigate to?
    // The option string is used to determine which navigation link to click, but it doesn't provide information about the type of page object to return. The Class<T> parameter allows the method to know
    // which specific page class to instantiate and return after performing the navigation action. This is essential for enabling type-safe returns and allowing the caller to work with the returned page object without needing to cast it.
    public <T extends BasePage> T to(String option, Class<T> pageClass) {
        switch (option.toUpperCase()) {
            case "DASHBOARD":
                dashboardLink.click();
                break;
            case "LEAVE":
                leaveLink.click();
                break;
            case "TIME":
                timeLink.click();
                break;
            case "RECRUITMENT":
                recruitmentLink.click();
                break;
            case "PERFORMANCE":
                performanceLink.click();
                break;
            case "ADMIN":
                adminLink.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid navigation option: " + option);
        }

        try {
            // Instantiate and return the requested page type
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate page class: " + pageClass.getName(), e);
        }
    }

    // Backward-compatible convenience method when caller doesn't care about a specific typed return
    public BasePage to(String option) {
        return to(option, BasePage.class);
    }



}
