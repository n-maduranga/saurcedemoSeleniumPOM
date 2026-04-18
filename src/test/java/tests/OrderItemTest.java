package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class OrderItemTest extends BaseTest {

    @Test(dataProvider = "excelData", dataProviderClass = dataprovider.ExcelDataProvider.class)
   // @Test(retryAnalyzer = retry.RetryAnalyzer.class)
    public void testOrderSingleItem(String firstName, String lastName, String zip)  {

        LoginPage login = new LoginPage();
        ProductPage productPage =login.login("standard_user", "secret_sauce");
        productPage.addItemToCart("Sauce Labs Backpack");
        CartPage cartpage = productPage.goToCart();
        CheckoutPage checkoutPage = cartpage.proceedToCheckout();
        OverviewPage overviewPage = checkoutPage.enterCheckoutInformation(firstName, lastName, zip);
        CompletePage completePage = overviewPage.finishCheckout();
        String message = completePage.getCompleteMessage();
        Assert.assertEquals(message, "THANK YOU FOR YOUR ORDER1");

    }
}
