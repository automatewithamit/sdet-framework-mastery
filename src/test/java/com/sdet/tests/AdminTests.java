package com.sdet.tests;

import com.sdet.pages.AdminPage;
import com.sdet.pages.DashboardPage;
import com.sdet.pages.LoginPage;
import org.testng.annotations.Test;

public class AdminTests extends BaseTest {
    @Test
    public void verifyUserCreation(){
        System.out.println("Executing Test verifyUserCreation");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = loginPage.loginToApplication("Admin", "admin123");

        dashboardPage.navigate.to("Admin");
        AdminPage adminPage = new AdminPage();
        adminPage.createUser("newuser", "password123", "ESS", "Enabled");

        adminPage.


    }
    @Test
    public void Test4_Admin(){
        System.out.println("Executing Test Test4_Admin");
    }
}
