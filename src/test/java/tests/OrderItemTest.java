package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class OrderItemTest extends BaseTest {

    // @Test(retryAnalyzer = retry.RetryAnalyzer.class) - No need to add retry analyzer here as we are using RetryListener
  @Test(dataProvider = "excelData", dataProviderClass = dataprovider.ExcelDataProvider.class)
  public void testOrderSingleItem(String firstName, String lastName, String zip)  {
        LoginPage login = new LoginPage();
        ProductPage productPage =login.login("standard_user", "secret_sauce");
        productPage.addItemToCart("Sauce Labs Backpack");
        CartPage cartpage = productPage.goToCart();
        CheckoutPage checkoutPage = cartpage.proceedToCheckout();
        OverviewPage overviewPage = checkoutPage.enterCheckoutInformation(firstName, lastName, zip);
        CompletePage completePage = overviewPage.finishCheckout();
        String message = completePage.getCompleteMessage();
        Assert.assertEquals(message, "Thank you for your order!");

    }

    @Test
    public void testOrderMultipleItem( )  {
        LoginPage login = new LoginPage();
        ProductPage productPage =login.login("standard_user", "secret_sauce");
        productPage.addMultipleItemsToCart("Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket");
        CartPage cartpage = productPage.goToCart();
        CheckoutPage checkoutPage = cartpage.proceedToCheckout();
        OverviewPage overviewPage = checkoutPage.enterCheckoutInformation("DD", "FF", "3232");
        CompletePage completePage = overviewPage.finishCheckout();
        String message = completePage.getCompleteMessage();
        Assert.assertEquals(message, "Thank you for your order!");

    }


}
