package ru.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.saucedemo.pages.CheckoutPage;
import ru.saucedemo.pages.InventoryPage;
import ru.saucedemo.pages.LoginPage;
import ru.saucedemo.utils.TestConfig;

public class CheckoutTests extends BaseTest {

    @Test
    public void successfulCheckoutTest() {
        InventoryPage inventory = new LoginPage(driver)
                .open()
                .loginAs(TestConfig.STANDARD_USER, TestConfig.PASSWORD);

        CheckoutPage checkout = inventory
                .addProduct("Sauce Labs Backpack")
                .openCart()
                .checkout();

        checkout
                .fillCustomerData("Maxim", "Test", "123456")
                .continueCheckout()
                .finishOrder();

        Assert.assertEquals(
                checkout.getCompleteMessage(),
                "Thank you for your order!",
                "Ожидалось сообщение об успешном оформлении заказа"
        );
    }
}
