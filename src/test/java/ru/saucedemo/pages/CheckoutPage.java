package ru.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.cssSelector(".complete-header");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage fillCustomerData(String first, String last, String postal) {
        type(firstName, first);
        type(lastName, last);
        type(postalCode, postal);
        return this;
    }

    public CheckoutPage continueCheckout() {
        click(continueButton);
        return this;
    }

    public CheckoutPage finishOrder() {
        click(finishButton);
        return this;
    }

    public String getCompleteMessage() {
        return text(completeHeader);
    }

    public String getErrorMessage() {
        return text(errorMessage);
    }
}
