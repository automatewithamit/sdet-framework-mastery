package com.sdet.pages;

import com.microsoft.playwright.Locator;

public class DashboardPage extends BasePage {
    Locator dashboardHeader = page.getByText("dashboard");
    public NavigationPage navigate;

    public DashboardPage() {
        // Wait for the dashboard header to be visible to ensure the page has loaded
        navigate  = new NavigationPage();


    }
    public boolean verifyDashboardPageLoaded(){
        String text = dashboardHeader.textContent();

        //page.isVisible(dashboardHeader);
        return text != null && text.equalsIgnoreCase("Dashboard");
    }
    public AdminPage navigateToAdminPage(){
        // use the generic navigation to return a typed AdminPage
        return navigate.to("Admin", AdminPage.class);
    }

}
