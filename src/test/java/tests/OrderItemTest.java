package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class OrderItemTest extends BaseTest {

    @Test
    public void testOrderSingleItem() throws InterruptedException {

        LoginPage login = new LoginPage();
        login.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage();
        productPage.addItemToCart("Sauce Labs Backpack");

    }

}
