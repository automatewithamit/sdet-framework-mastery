package com.sdet.pages;
import com.microsoft.playwright.Page;
import com.sdet.framework.core.DriverManager;

public class BasePage {
        Page page;
        public BasePage() {
            // Initialize the browser and page when the BasePage is instantiated
            page = DriverManager.getPage();
        }
}
