package com.sdet.tests;

import com.microsoft.playwright.*;
import com.sdet.framework.core.DriverManager;
import com.sdet.framework.helper.PropertiesReader;
import org.testng.annotations.*;

public class BaseTest {

    Page page;

    @BeforeMethod
    public void beforeMethod(){
        DriverManager.initializeBrowser();
        page = DriverManager.getPage();
        navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    public static void navigateTo(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }
        DriverManager.getPage().navigate(url);
        System.out.println("Navigated to: " + url);
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Executing beforeClass");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Executing beforeSuite");
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
        DriverManager.closePage();
        DriverManager.closeContext();
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Executing afterClass");
    }
    @AfterSuite
    public void afterSuite(){
        DriverManager.closeBrowser();
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Executing afterTest");
    }
    @AfterGroups
    public void afterGroups(){

    }
}
