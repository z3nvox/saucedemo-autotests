package ru.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.saucedemo.pages.CartPage;
import ru.saucedemo.pages.InventoryPage;
import ru.saucedemo.pages.LoginPage;
import ru.saucedemo.utils.TestConfig;

public class CartTests extends BaseTest {

    @Test
    public void addProductToCartTest() {
        InventoryPage inventory = new LoginPage(driver)
                .open()
                .loginAs(TestConfig.STANDARD_USER, TestConfig.PASSWORD);

        inventory.addProduct("Sauce Labs Backpack");

        Assert.assertEquals(
                inventory.getCartCount(),
                "1",
                "Ожидался счётчик корзины 1"
        );

        CartPage cart = inventory.openCart();

        Assert.assertEquals(
                cart.getItemName(),
                "Sauce Labs Backpack",
                "В корзине должен находиться Sauce Labs Backpack"
        );
        Assert.assertEquals(
                cart.getItemPrice(),
                "$29.99",
                "Ожидалась цена $29.99"
        );
    }
}
