package com.sdet.pages;

import com.microsoft.playwright.options.LoadState;

public class LoginPage extends BasePage {


    public void loginToApplication(String username, String password){
        page.locator("input[name='username']").fill(username);
        page.locator("input[name='password']").fill(password);
        page.locator("button[type='submit']").click();
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

}
