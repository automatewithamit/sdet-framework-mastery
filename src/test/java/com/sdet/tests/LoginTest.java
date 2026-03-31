package com.sdet.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.sdet.pages.LoginPage;
import org.testng.annotations.*;

public class LoginTest extends BaseTest{


    @Test
    public void validateCorrectLogin(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication("Admin", "admin123");
        assert page.url().contains("/dashboard/index");
        //assert that user is navigated to dashboard page


    }
    @Test
    public void validateIncorrectLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToApplication("Admin", "wrongpassword");
        //assert that error message is displayed
        String errorMessage = page.locator("div[role='alert']").innerText();
        System.out.println("Error Message: " + errorMessage);
        //assert that error message contains "Invalid credentials"
        assert errorMessage.contains("Invalid credentials");

    }



}
