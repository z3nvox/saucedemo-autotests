package ru.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {

    private final By productsTitle = By.cssSelector(".title");
    private final By cartLink = By.cssSelector(".shopping_cart_link");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By sortSelect =
            By.cssSelector("[data-test='product-sort-container']");

    public InventoryPage(WebDriver driver) {
        super(driver);
        visible(productsTitle);
    }

    public String getTitle() {
        return text(productsTitle);
    }

    public String getCartCount() {
        return text(cartBadge);
    }

    public InventoryPage addProduct(String productName) {
        click(productButton(productName, "Add to cart"));
        return this;
    }

    public InventoryPage removeProduct(String productName) {
        click(productButton(productName, "Remove"));
        return this;
    }

    public CartPage openCart() {
        click(cartLink);
        return new CartPage(driver);
    }

    public InventoryPage sortBy(String value) {
        Select select = new Select(visible(sortSelect));
        select.selectByValue(value);
        return this;
    }

    public String getFirstProductName() {
        return text(By.cssSelector(".inventory_item_name"));
    }

    private By productButton(String productName, String buttonText) {
        return By.xpath(
                "//div[contains(@class,'inventory_item')]"
                        + "[.//div[contains(@class,'inventory_item_name') and normalize-space()="
                        + quote(productName) + "]]"
                        + "//button[normalize-space()=" + quote(buttonText) + "]"
        );
    }

    private String quote(String value) {
        return "'" + value.replace("'", "\\'") + "'";
    }
}