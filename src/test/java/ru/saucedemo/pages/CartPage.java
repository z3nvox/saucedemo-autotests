package ru.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By checkoutButton = By.id("checkout");
    private final By cartItemNames = By.cssSelector(".inventory_item_name");
    private final By cartItemPrices = By.cssSelector(".inventory_item_price");

    public CartPage(WebDriver driver) {
        super(driver);
        visible(checkoutButton);
    }

    public String getItemName() {
        return text(cartItemNames);
    }

    public String getItemPrice() {
        return text(cartItemPrices);
    }

    public CheckoutPage checkout() {
        click(checkoutButton);
        return new CheckoutPage(driver);
    }
}
