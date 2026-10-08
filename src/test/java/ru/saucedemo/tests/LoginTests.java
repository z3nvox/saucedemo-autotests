package ru.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.saucedemo.pages.InventoryPage;
import ru.saucedemo.pages.LoginPage;
import ru.saucedemo.utils.TestConfig;

public class LoginTests extends BaseTest {

    @Test
    public void successfulLoginTest() {
        InventoryPage inventory = new LoginPage(driver)
                .open()
                .loginAs(TestConfig.STANDARD_USER, TestConfig.PASSWORD);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/inventory.html"),
                "Ожидался переход на /inventory.html, фактический URL: " + driver.getCurrentUrl()
        );
        Assert.assertEquals(
                inventory.getTitle(),
                "Products",
                "Ожидался заголовок Products"
        );
    }

    @Test
    public void lockedUserLoginTest() {
        LoginPage login = new LoginPage(driver)
                .open()
                .loginAsLockedUser(TestConfig.LOCKED_USER, TestConfig.PASSWORD);

        String error = login.getErrorMessage();

        Assert.assertTrue(
                error.contains("Epic sadface"),
                "Ожидалось сообщение об ошибке Epic sadface, фактически: " + error
        );
    }
}
