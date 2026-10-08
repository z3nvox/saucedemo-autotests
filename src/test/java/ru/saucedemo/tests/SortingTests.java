package ru.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.saucedemo.pages.InventoryPage;
import ru.saucedemo.pages.LoginPage;
import ru.saucedemo.utils.TestConfig;

public class SortingTests extends BaseTest {

    @Test
    public void sortProductsAToZTest() {
        InventoryPage inventory = new LoginPage(driver)
                .open()
                .loginAs(TestConfig.STANDARD_USER, TestConfig.PASSWORD);

        inventory.sortBy("az");

        Assert.assertEquals(
                inventory.getFirstProductName(),
                "Sauce Labs Backpack",
                "После сортировки A-Z первым должен быть Sauce Labs Backpack"
        );
    }

    @Test
    public void sortProductsPriceLowToHighTest() {
        InventoryPage inventory = new LoginPage(driver)
                .open()
                .loginAs(TestConfig.STANDARD_USER, TestConfig.PASSWORD);

        inventory.sortBy("lohi");

        Assert.assertEquals(
                inventory.getFirstProductName(),
                "Sauce Labs Onesie",
                "После сортировки Price Low to High первым должен быть Sauce Labs Onesie"
        );
    }
}
