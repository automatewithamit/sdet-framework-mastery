package com.sdet.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;

    public class LoginPage extends BasePage {
        Locator userNameTextBox = page.locator("input[name='username']");
        Locator passwordTextBox = page.locator("input[name='password']");
        Locator loginButton = page.locator("button[type='submit']");

    public DashboardPage loginToApplication(String username, String password){

        enterText(userNameTextBox, username);
        enterText(passwordTextBox, password);
        click(loginButton);
//        button.click(loginButton);
//
        return new DashboardPage();
        //assert dashboardPage.verifyDashboardPageLoaded() : "Dashboard page did not load successfully after login
    }



}
