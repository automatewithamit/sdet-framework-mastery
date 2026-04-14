package com.sdet.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.sdet.framework.webelements.Button;
import com.sdet.framework.webelements.TextBox;
import com.sdet.pages.locators.AdminLocators;
import org.w3c.dom.Text;

public class AdminPage extends BasePage {
    AdminLocators adminLocators;
    public AdminPage() {
        super();
        adminLocators = new AdminLocators();
    }
//    Locator addUserButton = page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Add"));
//    Locator userNameTextBox = page.locator("//label[text()='Username']/../..//input");
//    Locator passwordTextBox = page.locator("//label[text()='Password']/../..//input");
//    Locator confirmPasswordTextBox = page.locator("//label[text()='Comfirm Password']/../..//input");
//    Locator roleDropdown = page.locator("select[name='role']");
//    Locator statusDropdown = page.locator("select[name='status']");
//    Locator saveButton = page.locator("button[type='submit']");

    Locator searchButton = page.locator("button[type='submit']");
    //
    TextBox userNameTextBox1 = new TextBox("Username");
    Button loginBtn = new Button( "Login");


    public void createUser(String username, String password, String role, String status) {
            loginBtn.click();
            userNameTextBox1.enterText("Admin");

            enterText(adminLocators.userNameTextBox, username);
            enterText(passwordTextBox, password);
            enterText(confirmPasswordTextBox, password);

            roleDropdown.selectOption(role);
            statusDropdown.selectOption(status);
            click(saveButton);
            System.out.println("User created successfully: " + username);

//        userNameTextBox.fill(username);
//        passwordTextBox.fill(password);
//        confirmPasswordTextBox.fill(password);
//        roleDropdown.selectOption(role);
//        statusDropdown.selectOption(status);
//        button.click(saveButton);
//        System.out.println("User created successfully: " + username);
    }

    public void searchUserByUsername(String username) {
        userNameTextBox.fill(username);
        button.click(searchButton);
    }


    //TextBoxes
    //DropDowns
    //Buttons
    //Tables
    //Modals




}
