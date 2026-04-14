package com.sdet.pages.locators;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.sdet.pages.BasePage;

public  class AdminLocators extends BasePage {
    public AdminLocators() {
        super();
    }
    Locator addUserButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Add"));
    Locator userNameTextBox = page.locator("//label[text()='Username']/../..//input");
    Locator passwordTextBox = page.locator("//label[text()='Password']/../..//input");
    Locator confirmPasswordTextBox = page.locator("//label[text()='Comfirm Password']/../..//input");
    Locator roleDropdown = page.locator("select[name='role']");
    Locator statusDropdown = page.locator("select[name='status']");
    Locator saveButton = page.locator("button[type='submit']");
}
