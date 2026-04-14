package com.sdet.pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.sdet.framework.core.PlaywrightManager;
import com.sdet.framework.webelements.Button;
import com.sdet.framework.webelements.ElementActions;

public class BasePage extends ElementActions {
        //SOLID principle: BasePage should not have direct dependencies on specific web elements like Button. Instead, it should provide common functionalities that can be used by all page classes without being tightly coupled to specific element implementations.
        // S -> SRP - BasePage should have a single responsibility, which is to provide common functionalities for all page classes. It should not be responsible for handling specific web elements like buttons or text boxes.
        // This allows for better maintainability and separation of concerns.
    Page page;

        Button button;
        public BasePage() {
            // Initialize the browser and page when the BasePage is instantiated
            page = PlaywrightManager.getPage();

        }



        public void click(Locator buttonLocator) {
            System.out.println("Button with locator "+ buttonLocator +"clicked successfully.");
            buttonLocator.click();
            System.out.println("Button clicked successfully.");
        }
        public void selectOption(Locator dropdownLocator, String optionValue) {
            System.out.println("Selecting option '" + optionValue + "' from dropdown with locator " + dropdownLocator);
            dropdownLocator.selectOption(optionValue);
            System.out.println("Option selected successfully.");
        }
}
