package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class OrderItemTest extends BaseTest {

    @Test
    public void testOrderSingleItem()  {

        LoginPage login = new LoginPage();
        ProductPage productPage =login.login("standard_user", "secret_sauce");
        productPage.addItemToCart("Sauce Labs Backpack");
        CartPage cartpage = productPage.goToCart();
        CheckoutPage checkoutPage = cartpage.proceedToCheckout();
        OverviewPage overviewPage = checkoutPage.enterCheckoutInformation("John", "Doe", "12345");
        CompletePage completePage = overviewPage.finishCheckout();
        String message = completePage.getCompleteMessage();
        System.out.println(message);

    }
}
