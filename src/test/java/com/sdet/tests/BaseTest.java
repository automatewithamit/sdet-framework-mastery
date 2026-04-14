package com.sdet.tests;

import com.microsoft.playwright.*;
import com.sdet.framework.core.PlaywrightManager;
import org.testng.annotations.*;

public abstract class BaseTest {

    Page page;

    @BeforeMethod
    public void beforeMethod(){

        navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    public static void navigateTo(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }
        PlaywrightManager.getPage().navigate(url);
        System.out.println("Navigated to: " + url);
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Executing beforeClass");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Executing beforeSuite");
        PlaywrightManager.initializeBrowser();
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Executing beforeTest");
    }
    @BeforeGroups
    public void beforeGroups(){

    }
    @AfterMethod
    public void afterMethod(){
        PlaywrightManager.closePage();
        PlaywrightManager.closeContext();
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Executing afterClass");
    }
    @AfterSuite
    public void afterSuite(){
        PlaywrightManager.closeBrowser();

    }
    @AfterTest
    public void afterTest(){
        System.out.println("Executing afterTest");
    }
    @AfterGroups
    public void afterGroups(){

    }
}
